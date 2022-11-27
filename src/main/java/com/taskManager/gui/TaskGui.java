package com.taskManager.gui;

import com.taskManager.controller.TaskController;

import javax.swing.*;
import java.awt.*;

public class TaskGui {

    private final TaskController tc = new TaskController();

    public void addComponents(Container container){

        TopPanel topPanel = new TopPanel();
        topPanel.setBackground(Color.GRAY);
        container.add(topPanel,BorderLayout.NORTH);

        MainPanel centralPanel = new MainPanel();
        container.add(centralPanel, BorderLayout.CENTER);

        BottomPanel bottomPanel = new BottomPanel(centralPanel);
        bottomPanel.setBackground(Color.GRAY);
        container.add(bottomPanel,BorderLayout.SOUTH);

    }
    public void createAndShow(){

        JFrame frame = new JFrame("Task Manager");
        frame.setPreferredSize(new Dimension(690,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        addComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}
