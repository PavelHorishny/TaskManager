package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel implements ActionListener {
    JTextField tf;
    JButton send;
    TaskController taskController =new TaskController();
    MainPanel centralPanel;
    TopPanel topPanel;
    public BottomPanel (TopPanel topPanel){
        this.topPanel = topPanel;

/*        JLabel label = new JLabel("Enter new task");
        tf = new JTextField(10);
        send = new JButton("Save task");
        send.addActionListener(this);

        this.add(label);
        this.add(tf);
        this.add(send);*/
    }
    public BottomPanel load( MainPanel centralPanel){
        this.removeAll();
        this.revalidate();
        this.repaint();
        JLabel label = new JLabel("Enter new task");
        tf = new JTextField(10);
        send = new JButton("Save task");
        send.addActionListener(this);

        this.add(label);
        this.add(tf);
        this.add(send);
        this.centralPanel = centralPanel;
        return  this;
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO check the empty string
        if(e.getSource()==send){

            taskController.post(tf.getText());
            centralPanel.loadList();
            tf.setText("");
        }
    }
    public void loadEdit(Task task){
        this.removeAll();
        this.revalidate();
        this.repaint();
        //TODO add buttons: delete, back to list, edit task
        JButton delete = new JButton("Delete task");
        delete.addActionListener(e -> {
            Response r = taskController.delete(task.getId());
            //TODO if delete returns ok then return list panel
            if(r.getStatus().equals(Status.OK)) {
                centralPanel.loadList();
                this.load(centralPanel);
                topPanel.load();
                }
            });

        JButton edit = new JButton("Edit task");
        edit.addActionListener(e -> System.out.println("edit panel"));

        JButton back = new JButton("Return to list");
        back.addActionListener(e->{
            topPanel.load();
            centralPanel.loadList();
            this.load(centralPanel);
        });
        this.add(delete);
        this.add(edit);
        this.add(back);
    }
}
