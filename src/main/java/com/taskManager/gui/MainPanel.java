package com.taskManager.gui;

import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;

import javax.swing.*;
import java.util.List;

public class MainPanel extends JPanel {
    List <Task> tasks;
    TaskController tc = new TaskController();

    public MainPanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        load();
    }

    public void load (){
        this.removeAll();
        this.revalidate();
        this.repaint();
        tasks = tc.get(0).getTasks();

        for (Task task : tasks) {
            this.add(new ListPanel(task));
        }
    }
}
