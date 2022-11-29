package com.taskManager.gui;

import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;

import javax.swing.*;
import java.util.List;

public class MainPanel extends JPanel {
    List <Task> tasks;
    TaskController tc = new TaskController();
    TopPanel topPanel;
    BottomPanel bottomPanel;

    public MainPanel(TopPanel topPanel,BottomPanel bottomPanel){
        this.topPanel = topPanel;
        this.bottomPanel = bottomPanel;
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        loadList();
    }

    public void loadList(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        tasks = tc.get(0).getTasks();

        for (Task task : tasks) {
            this.add(new ListPanel(task,this,topPanel,bottomPanel));
        }
    }
    public void loadTask(Task task){
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(new TaskPanel(task, this, topPanel));
    }
    //TODO resolve issue saving data on changing panels or on closing
}
