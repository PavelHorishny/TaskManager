package com.taskManager.gui;

import javax.swing.*;
import java.awt.*;

public class TaskGui {

    public void addComponents(Container container){


        TopPanel topPanel = new TopPanel();
        topPanel.setBackground(Color.GRAY);
        container.add(topPanel.load(),BorderLayout.NORTH);

        BottomPanel bottomPanel = new BottomPanel(topPanel);
        bottomPanel.setBackground(Color.GRAY);

        MainPanel centralPanel = new MainPanel(topPanel,bottomPanel);
        JScrollPane scroll = new JScrollPane(centralPanel);
        scroll.setPreferredSize(new Dimension(700,330));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        container.add(scroll,BorderLayout.CENTER);

/*        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.setBackground(Color.GRAY);*/
        container.add(bottomPanel.load(centralPanel),BorderLayout.SOUTH);
        container.add(scroll,BorderLayout.CENTER);


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
