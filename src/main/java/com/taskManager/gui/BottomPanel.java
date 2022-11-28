package com.taskManager.gui;

import com.taskManager.controller.TaskController;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel implements ActionListener {
    JTextField tf;
    JButton send;
    TaskController taskController =new TaskController();
    MainPanel centralPanel;
    public BottomPanel (MainPanel panel){

        centralPanel = panel;
        JLabel label = new JLabel("Enter new task");
        tf = new JTextField(10);
        send = new JButton("Save task");
        send.addActionListener(this);

        this.add(label);
        this.add(tf);
        this.add(send);
    }


    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==send){

            taskController.post(tf.getText());
            centralPanel.loadList();
            tf.setText("");
        }
    }
}
