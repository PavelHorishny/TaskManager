package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import test.TestingTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ListPanel extends JPanel implements ActionListener {

    JLabel id;
    JLabel name;
    JLabel startDate;
    JLabel endDate;
    JLabel time;
    JButton timer;
    TaskController taskController = new TaskController();
    Timer t;
    int k = 0;
    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");

    public ListPanel(Task task){

        this.setPreferredSize(new Dimension(690,30));

        id = new JLabel();
        id.setText(String.valueOf(task.getId()));
        id.setPreferredSize(new Dimension(30,30));
        this.add(id);

        name = new JLabel();
        name.setText(task.getName());
        name.setPreferredSize(new Dimension(280,30));
        this.add(name);

        startDate = new JLabel();
        startDate.setText(df.format(task.getCreatedDateTime()));
        startDate.setPreferredSize(new Dimension(90,30));
        this.add(startDate);

        endDate = new JLabel();
        if(task.getFinishedDateTime()!=null){
            endDate.setText(df.format(task.getFinishedDateTime()));
        }else{
            endDate.setText("not finished");
        }
        endDate.setPreferredSize(new Dimension(90,30));
        this.add(endDate);

        time = new JLabel();
        time.setText(TestingTimer.convertTime(task.getSTime()));
        time.setPreferredSize(new Dimension(70,30));
        this.add(time);
        k=task.getSTime();

        timer = new JButton();
        timer.setText("Start");
        timer.addActionListener(this);
        timer.setPreferredSize(new Dimension(70,20));
        this.add(timer, BorderLayout.LINE_END);
        if(task.getFinishedDateTime()!=null){
            timer.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO make to show time pretty
        if(e.getSource()==timer&&timer.getText().equals("Start")){
            t=new Timer(1000, e1 -> {
                k++;
                time.setText(TestingTimer.convertTime(k));
            });
            t.start();
            timer.setText("Stop");
            endDate.setText("in progress");
        }else{
            t.stop();
            Response r = taskController.put(Integer.parseInt(id.getText()),null,null,k);
            //TODO check response
            time.setText(TestingTimer.convertTime(k));
            timer.setText("Start");
            endDate.setText("not finished");
            this.revalidate();
            this.repaint();
        }
    }
}