package com.taskManager.gui;

import com.taskManager.storage.entity.Task;

import javax.swing.*;
import java.awt.*;


public class TopPanel extends JPanel {

    JLabel label;
    GridBagConstraints gbc;


    public TopPanel() {

    }

    public TopPanel load() {
        this.removeAll();
        this.revalidate();
        this.repaint();

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());

        label = new JLabel();
        label.setText("No.");
        label.setPreferredSize(new Dimension(30, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(label, gbc);

        label = new JLabel();
        label.setText("Task");
        label.setPreferredSize(new Dimension(280, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(label, gbc);

        label = new JLabel();
        label.setText("Added");
        label.setPreferredSize(new Dimension(90, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(label, gbc);

        label = new JLabel();
        label.setText("Finished");
        label.setPreferredSize(new Dimension(90, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(label, gbc);

        label = new JLabel();
        label.setText("Time");
        label.setPreferredSize(new Dimension(70, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1;
        this.add(label, gbc);

        label = new JLabel();
        label.setText("Timer");
        label.setPreferredSize(new Dimension(70, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(label, gbc);
        return this;
    }

    public void loadEdit(Task task) {
        //TODO make separate method for reloading
        this.removeAll();
        this.revalidate();
        this.repaint();

        JLabel label = new JLabel(task.getName());
        gbc = new GridBagConstraints();
        gbc.fill = 2;
        gbc.ipady = 15;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(label, gbc);
    }
}
