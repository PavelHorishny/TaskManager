package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import com.taskManager.utility.TaskAppUtility;

import javax.swing.*;
import java.awt.*;


public class TaskPanel extends JPanel {

    TaskController taskController = new TaskController();
    GridBagConstraints gbc;

    public TaskPanel(Task task, MainPanel main, TopPanel topPanel, BottomPanel bottomPanel) {

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());

        JLabel idLabel = new JLabel("id ");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(idLabel, gbc);

        JLabel idText = new JLabel(String.valueOf(task.getId()));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.WEST;
        this.add(idText, gbc);

        JLabel nameLabel = new JLabel("Task name ");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(nameLabel, gbc);

        JLabel nameText = new JLabel(task.getName());
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(nameText, gbc);

        JLabel startDateLabel = new JLabel("Start date ");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(startDateLabel, gbc);

        JLabel startDateText = new JLabel(TaskAppUtility.checkDate(task.getCreatedDateTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(startDateText, gbc);

        JLabel endDateLabel = new JLabel("End date ");
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(endDateLabel, gbc);

        JLabel endDateText = new JLabel(TaskAppUtility.checkDate(task.getFinishedDateTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(endDateText, gbc);

        JLabel timeLabel = new JLabel("Spent time ");
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(timeLabel, gbc);

        JLabel timeText = new JLabel(TaskAppUtility.convertTime(task.getSTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(timeText, gbc);

        JLabel descriptionLabel = new JLabel("Short description ");
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(descriptionLabel, gbc);

        JLabel descriptionText = new JLabel("nothing here yet");
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(descriptionText, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(Box.createGlue(), gbc);

        JButton finish = new JButton("Finish task");
        gbc = new GridBagConstraints();
        finish.addActionListener(e -> {
            Response response = taskController.put(task.getId(), null, "finished", task.getSTime());
            if (response.getStatus().equals(Status.OK)) {
                main.showListView();
                topPanel.load();
                bottomPanel.showMainView(main);
            }else{
                JOptionPane.showMessageDialog(null,response.getException().getMessage(),"Some error occurred",JOptionPane.ERROR_MESSAGE);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets = new Insets(0, 0, 5, 5);
        this.add(finish, gbc);

    }
}
