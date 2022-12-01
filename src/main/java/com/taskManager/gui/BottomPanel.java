package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import com.taskManager.utility.TaskAppUtility;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel implements ActionListener {

    JTextField tf;
    JButton send;
    TaskController taskController = new TaskController();
    MainPanel mainPanel;
    TopPanel topPanel;

    public BottomPanel(TopPanel topPanel) {

        this.topPanel = topPanel;

    }

    public BottomPanel showMainView (MainPanel mainPanel) {

        TaskAppUtility.reloadPanel(this);

        JLabel label = new JLabel("Enter new task");
        tf = new JTextField(10);
        send = new JButton("Save task");
        send.addActionListener(this);

        this.add(label);
        this.add(tf);
        this.add(send);
        this.mainPanel = mainPanel;

        return this;

    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO check the empty string
        if (e.getSource() == send) {
            if(tf.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter name of your task first","Warning",JOptionPane.WARNING_MESSAGE);
            }else{
                Response response = taskController.post(tf.getText());
                if(response.getStatus().equals(Status.OK)){
                    mainPanel.showListView();
                    tf.setText("");
                }else{
                    JOptionPane.showMessageDialog(null,response.getException().getMessage(),"Some error occurred",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void showTaskView(Task task) {

        TaskAppUtility.reloadPanel(this);

        JButton delete = new JButton("Delete task");
        delete.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete operation", JOptionPane.YES_NO_CANCEL_OPTION);

            if(answer==0){
                Response response = taskController.delete(task.getId());
                if(response.getStatus().equals(Status.OK)){
                    mainPanel.showListView();
                    this.showMainView(mainPanel);
                    topPanel.load();
                }else{
                    JOptionPane.showMessageDialog(null,response.getException().getMessage(),"Some error occurred",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton edit = new JButton("Edit task");
        edit.addActionListener(e -> {
            mainPanel.showEditView(task);
            this.showEditView(task);
        });

        JButton back = new JButton("Return to list");
        back.addActionListener(e -> {
            topPanel.load();
            mainPanel.showListView();
            this.showMainView(mainPanel);
        });

        this.add(delete);
        this.add(edit);
        this.add(back);

    }

    public void showEditView(Task task) {

        TaskAppUtility.reloadPanel(this);

        JButton back = new JButton("Return to task");
        back.addActionListener(e -> {
            topPanel.loadEdit(task);
            mainPanel.showTaskView(task);
            this.showTaskView(task);
        });

        this.add(back);

    }
}
