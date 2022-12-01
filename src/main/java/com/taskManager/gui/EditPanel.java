package com.taskManager.gui;

import com.taskManager.storage.entity.Task;
import test.TestingTimer;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class EditPanel extends JPanel {
    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
    GridBagConstraints gbc;
    public EditPanel(Task task){

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());

        JLabel taskName = new JLabel("Task name");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(taskName,gbc);

        JTextField textName = new JTextField(task.getName());
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(textName,gbc);

        JLabel startDate = new JLabel("Start date");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(startDate,gbc);

        JLabel textStartDate = new JLabel (df.format(task.getCreatedDateTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(textStartDate,gbc);

        JLabel endDate =new JLabel("End date");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(endDate,gbc);

        JLabel textEndDate = new JLabel();
        if(task.getFinishedDateTime()==null){
            textEndDate.setText("not finished");
        }else{
            textEndDate.setText(df.format(task.getFinishedDateTime()));
        }
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(textEndDate,gbc);

        JLabel timeSpent = new JLabel("Time spent");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(timeSpent,gbc);

        JLabel textTimeSpent = new JLabel(TestingTimer.convertTime(task.getSTime()));
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(textTimeSpent,gbc);

        JLabel description = new JLabel("Description");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,5,2,2);
        this.add(description,gbc);

        JTextField textDescription = new JTextField("nothing here yet");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2,2,2,2);
        this.add(textDescription,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(Box.createGlue(),gbc);

        JButton save = new JButton("Save");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx=1;
        gbc.gridy=6;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets = new Insets(0,0,5,5);
        this.add(save,gbc);
        //TODO make it look nice
        //TODO add description field to Task.class
        //TODO implement update
    }
}
