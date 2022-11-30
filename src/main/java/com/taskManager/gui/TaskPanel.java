package com.taskManager.gui;

import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import test.TestingTimer;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TaskPanel extends JPanel {
    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
    TaskController taskController = new TaskController();
    GridBagConstraints gbc;

    public TaskPanel(Task task, MainPanel main, TopPanel topPanel){
        //TODO refactor and make panel to look nice
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());

        JLabel idLabel = new JLabel("id ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty=0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
/*
        gbc.ipadx =340;
        gbc.ipady = 100;
        gbc.anchor = GridBagConstraints.EAST;*/
        this.add(idLabel,gbc);

        JLabel idText = new JLabel(String.valueOf(task.getId()));
        idText.setOpaque(true);
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(2,2,2,2);
        gbc.anchor = GridBagConstraints.WEST;
/*
        gbc.ipadx =340;
        gbc.ipady = 100;*/
        this.add(idText,gbc);

        JLabel nameLabel = new JLabel("Task name ");
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.GREEN);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(nameLabel,gbc);

        JLabel nameText = new JLabel(task.getName());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(nameText,gbc);

        JLabel startDateLabel = new JLabel("Start date ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(startDateLabel,gbc);

        JLabel startDateText = new JLabel(df.format(task.getCreatedDateTime()));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(startDateText,gbc);

        JLabel endDateLabel = new JLabel("End date ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(endDateLabel,gbc);

        //TODO make separate method to check date
        JLabel endDateText;
        if(task.getFinishedDateTime()!=null) {
            endDateText = new JLabel(df.format(task.getFinishedDateTime()));
        }else {
            endDateText = new JLabel("not finished yet");
        }
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(endDateText,gbc);

        JLabel timeLabel = new JLabel("Spent time ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(timeLabel,gbc);

        JLabel timeText = new JLabel(TestingTimer.convertTime(task.getSTime()));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(timeText,gbc);

        JLabel descriptionLabel = new JLabel("Short description ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,5,190,0);
        this.add(descriptionLabel,gbc);

        JLabel descriptionText = new JLabel("nothing here yet");
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,190,0);
        this.add(descriptionText,gbc);

        JButton finish = new JButton("Finish task");
        gbc = new GridBagConstraints();
        finish.addActionListener(e->{
            taskController.put(task.getId(),null,"finished", task.getSTime());
            //TODO resolve response
        });
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,0,0,5);
        this.add(finish, gbc);

    }
}
