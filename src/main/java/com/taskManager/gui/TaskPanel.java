package com.taskManager.gui;

import com.taskManager.storage.entity.Task;
import test.TestingTimer;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;


public class TaskPanel extends JPanel {
    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");

    public TaskPanel(Task task, MainPanel main, TopPanel topPanel){
        //TODO refactor and make panel to look nice
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.RELATIVE;
        JLabel idLabel = new JLabel("id ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        idLabel.setPreferredSize(new Dimension(50,20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(idLabel,gbc);
        JLabel idText = new JLabel(String.valueOf(task.getId()));
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(idText,gbc);
        JLabel nameLabel = new JLabel("Task name ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        idLabel.setPreferredSize(new Dimension(50,20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(nameLabel,gbc);
        JLabel nameText = new JLabel(task.getName());
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(nameText,gbc);
        JLabel startDateLabel = new JLabel("Start date ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        idLabel.setPreferredSize(new Dimension(50,20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(startDateLabel,gbc);
        JLabel startDateText = new JLabel(df.format(task.getCreatedDateTime()));
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(startDateText,gbc);
        JLabel endDateLabel = new JLabel("End date ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        idLabel.setPreferredSize(new Dimension(50,20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(endDateLabel,gbc);
        JLabel endDateText;
        if(task.getFinishedDateTime()!=null) {
            endDateText = new JLabel(df.format(task.getFinishedDateTime()));
        }else {
            endDateText = new JLabel("not finished yet");
        }
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(endDateText,gbc);
        JLabel timeLabel = new JLabel("Spent time ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        idLabel.setPreferredSize(new Dimension(50,20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(timeLabel,gbc);
        JLabel timeText = new JLabel(TestingTimer.convertTime(task.getSTime()));
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(timeText,gbc);
        JLabel descriptionLabel = new JLabel("Short description ");
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.GRAY);
        idLabel.setPreferredSize(new Dimension(50,20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(descriptionLabel,gbc);
        JLabel descriptionText = new JLabel("nothing here yet");
        idText.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(descriptionText,gbc);
        JButton getBack = new JButton("return");
        getBack.addActionListener(e -> {
            topPanel.load();
            main.loadList();
        });
        gbc = new GridBagConstraints();
        gbc.gridx =3;
        gbc.gridy = 4;
        this.add(getBack,gbc);
    }
}
