package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import com.taskManager.utility.TaskAppUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ListPanel extends JPanel implements ActionListener {

    JLabel id;
    JLabel name;
    JLabel startDate;
    JLabel endDate;
    JLabel time;
    JButton timer;
    GridBagConstraints gbc;
    TaskController taskController = new TaskController();
    Timer t;
    int k;
    MainPanel main;
    TopPanel topPanel;

    public ListPanel(Task task, MainPanel main, TopPanel topPanel, BottomPanel bottomPanel, int no) {
        this.main = main;
        this.topPanel = topPanel;

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());

        id = new JLabel();
        id.setText(String.valueOf(no));
        id.setPreferredSize(new Dimension(30, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(id, gbc);

        name = new JLabel();
        name.setText(task.getName());
        name.setPreferredSize(new Dimension(280, 30));
        name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("pressed" + name.getText());
                topPanel.loadEdit(task);
                main.showTaskView(task);
                bottomPanel.showTaskView(task);
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(name, gbc);

        startDate = new JLabel();
        startDate.setText(TaskAppUtility.checkDate(task.getCreatedDateTime()));
        startDate.setPreferredSize(new Dimension(90, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(startDate, gbc);

        endDate = new JLabel(TaskAppUtility.checkDate(task.getFinishedDateTime()));
        endDate.setPreferredSize(new Dimension(90, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(endDate, gbc);

        time = new JLabel();
        time.setText(TaskAppUtility.convertTime(task.getSTime()));
        time.setPreferredSize(new Dimension(70, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(time, gbc);
        k = task.getSTime();

        timer = new JButton();
        timer.setText("Start");
        timer.addActionListener(this);
        timer.setPreferredSize(new Dimension(70, 20));
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(timer, gbc);
        if (task.getFinishedDateTime() != null) {
            timer.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer && timer.getText().equals("Start")) {
            t = new Timer(1000, e1 -> {
                k++;
                time.setText(TaskAppUtility.convertTime(k));
            });
            t.start();
            timer.setText("Stop");
            endDate.setText("in progress");
        } else {
            t.stop();
            Response response = taskController.put(Integer.parseInt(id.getText()), null, null, k);

            if(response.getStatus().equals(Status.OK)){
                time.setText(TaskAppUtility.convertTime(k));
                timer.setText("Start");
                endDate.setText("not finished");
                this.revalidate();
                this.repaint();
            }else{
                JOptionPane.showMessageDialog(null,response.getException().getMessage(),"Some error occurred",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
