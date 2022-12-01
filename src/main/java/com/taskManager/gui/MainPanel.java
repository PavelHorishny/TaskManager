package com.taskManager.gui;

import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.controller.TaskController;
import com.taskManager.storage.entity.Task;
import com.taskManager.utility.TaskAppUtility;

import javax.swing.*;
import java.util.List;

public class MainPanel extends JPanel {
    List<Task> tasks;
    TaskController taskController = new TaskController();
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
        Response response = taskController.get(0);
        if(response.getStatus().equals(Status.OK)){
            tasks = response.getTasks();
            if(tasks.size()<1){
                this.add(new JLabel("Add your first task"));
            }else {
                for (Task task : tasks) {
                    this.add(new ListPanel(task, this, topPanel, bottomPanel));
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,response.getException().getMessage(),"Some error occurred",JOptionPane.ERROR_MESSAGE);
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
