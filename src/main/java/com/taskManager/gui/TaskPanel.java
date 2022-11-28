package com.taskManager.gui;

import com.taskManager.storage.entity.Task;

import javax.swing.*;


public class TaskPanel extends JPanel {
    public TaskPanel(Task task, MainPanel main){
        JLabel label = new JLabel("id");
        JLabel idLabel = new JLabel(String.valueOf(task.getId()));
        JButton getBack = new JButton("return");
        getBack.addActionListener(e -> main.loadList());
        this.add(label);
        this.add(idLabel);
        this.add(getBack);
    }
}
