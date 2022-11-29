package com.taskManager.gui;

import com.taskManager.storage.entity.Task;

import javax.swing.*;
import java.awt.*;


public class TopPanel extends JPanel {

    JLabel label;



    public TopPanel(){

/*        this.setPreferredSize(new Dimension(690,30));

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
        this.add(label);*/
    }
    public TopPanel load(){
        this.removeAll();
        this.revalidate();
        this.repaint();
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
        return this;
    }

    public void loadEdit(Task task){
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(new JLabel(task.getName()));
    }
}
