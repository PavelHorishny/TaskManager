package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import com.taskManager.utility.TaskAppUtility;

import javax.swing.*;
import java.awt.*;

public class EditPanel extends JPanel {
    GridBagConstraints gbc;
    TaskController taskController = new TaskController();

    public EditPanel(Task task, MainPanel mainPanel) {

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());

        JLabel taskName = new JLabel("Task name");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(taskName, gbc);

        JTextField textName = new JTextField(task.getName());
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(textName, gbc);

        JLabel startDate = new JLabel("Start date");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(startDate, gbc);

        JLabel textStartDate = new JLabel(TaskAppUtility.checkDate(task.getCreatedDateTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(textStartDate, gbc);

        JLabel endDate = new JLabel("End date");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(endDate, gbc);

        JLabel textEndDate = new JLabel(TaskAppUtility.checkDate(task.getFinishedDateTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(textEndDate, gbc);

        JLabel timeSpent = new JLabel("Time spent");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(timeSpent, gbc);

        JLabel textTimeSpent = new JLabel(TaskAppUtility.convertTime(task.getSTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(textTimeSpent, gbc);

        JLabel description = new JLabel("Description");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 2);
        this.add(description, gbc);

        JTextField textDescription = new JTextField("nothing here yet");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        this.add(textDescription, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(Box.createGlue(), gbc);

        JButton save = new JButton("Save changes");
        save.addActionListener(e->{
            String details = textDescription.getText();
            String changedName = textName.getText();
            if(changedName.equals(task.getName())&&details.equals("nothing here yet")){
                JOptionPane.showMessageDialog(null,"No changes were made","Warning",JOptionPane.WARNING_MESSAGE);
            }else{
                Response response = taskController.put(task.getId(),changedName,null,0);
                if(response.getStatus().equals(Status.OK)){
                    JOptionPane.showMessageDialog(null,"Task is updated","Success",JOptionPane.PLAIN_MESSAGE);
                    mainPanel.showTaskView(task);
                }else{
                    JOptionPane.showMessageDialog(null,response.getException().getMessage(),"Some error occurred",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets = new Insets(0, 0, 5, 5);
        this.add(save, gbc);

        //TODO add description field to Task.class and update put func
    }
}
