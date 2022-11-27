package com.taskManager.gui;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TopPanel extends JPanel {

    JLabel label;


    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
    public TopPanel(){

        this.setPreferredSize(new Dimension(690,30));

        label = new JLabel();
        label.setText("id");
        label.setPreferredSize(new Dimension(30,30));
        this.add(label);

        label = new JLabel();
        label.setText("Task");
        label.setPreferredSize(new Dimension(280,30));
        this.add(label);

        label = new JLabel();
        label.setText("Added");
        label.setPreferredSize(new Dimension(90,30));
        this.add(label);

        label = new JLabel();
        label.setText("Finished");
        label.setPreferredSize(new Dimension(90,30));
        this.add(label);

        label = new JLabel();
        label.setText("Time");
        label.setPreferredSize(new Dimension(70,30));
        this.add(label);

        label = new JLabel();
        label.setText("Timer");
        label.setPreferredSize(new Dimension(70,20));
        this.add(label);
    }
}
