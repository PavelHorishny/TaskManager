package com.taskManager.gui;

import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import com.taskManager.utility.TaskAppUtility;

import javax.swing.*;
import java.util.List;

public class MainPanel extends JPanel {
    List<Task> tasks;
    TaskController tc = new TaskController();
    TopPanel topPanel;
    BottomPanel bottomPanel;

    public MainPanel(TopPanel topPanel, BottomPanel bottomPanel) {
        this.topPanel = topPanel;
        this.bottomPanel = bottomPanel;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        showListView();
    }

    public void showListView() {
        TaskAppUtility.reloadPanel(this);
        tasks = tc.get(0).getTasks();
        //TODO resolve response
        for (Task task : tasks) {
            this.add(new ListPanel(task, this, topPanel, bottomPanel));
        }
    }

    public void showTaskView(Task task) {
        TaskAppUtility.reloadPanel(this);
        this.add(new TaskPanel(task, this, topPanel, bottomPanel));
    }

    //TODO resolve issue saving data on changing panels or on closing
    public void showEditView(Task task) {
        TaskAppUtility.reloadPanel(this);
        this.add(new EditPanel(task));
    }
}
