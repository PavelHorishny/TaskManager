package com.taskManager.gui;

import com.taskManager.storage.entity.Task;
import test.TestingTimer;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class EditPanel extends JPanel {
    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
    public EditPanel(Task task){
        JLabel taskName = new JLabel("Task name");
        JTextField textName = new JTextField(task.getName());

        JLabel startDate = new JLabel("Start date");
        JLabel textStartDate = new JLabel (df.format(task.getCreatedDateTime()));
        JLabel endDate =new JLabel("End date");
        JLabel textEndDate = new JLabel();
        if(task.getFinishedDateTime()==null){
            textEndDate.setText("not finished");
        }else{
            textEndDate.setText(df.format(task.getFinishedDateTime()));
        }
        JLabel timeSpent = new JLabel("Time spent");
        JLabel textTimeSpent = new JLabel(TestingTimer.convertTime(task.getSTime()));
        JLabel description = new JLabel("Description");
        JTextField textDescription = new JTextField("nothing here yet");
        JButton save = new JButton("Save");

        this.add(taskName);
        this.add(textName);
        this.add(startDate);
        this.add(textStartDate);
        this.add(endDate);
        this.add(textEndDate);
        this.add(timeSpent);
        this.add(textTimeSpent);
        this.add(description);
        this.add(textDescription);
        this.add(save);
        //TODO make it look nice
        //TODO add description field to Task.class
        //TODO implement update
    }
}
