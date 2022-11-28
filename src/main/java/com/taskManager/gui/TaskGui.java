package com.taskManager.gui;

import javax.swing.*;
import java.awt.*;

public class TaskGui {

    public void addComponents(Container container){


        TopPanel topPanel = new TopPanel();
        topPanel.setBackground(Color.GRAY);
        container.add(topPanel,BorderLayout.NORTH);

        MainPanel centralPanel = new MainPanel();
        JScrollPane scroll = new JScrollPane(centralPanel);
        scroll.setPreferredSize(new Dimension(700,330));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        container.add(scroll,BorderLayout.CENTER);

        BottomPanel bottomPanel = new BottomPanel(centralPanel);
        bottomPanel.setBackground(Color.GRAY);
        container.add(bottomPanel,BorderLayout.SOUTH);


    }
    public void createAndShow(){

        JFrame frame = new JFrame("Task Manager");
        frame.setPreferredSize(new Dimension(710,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        addComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}
