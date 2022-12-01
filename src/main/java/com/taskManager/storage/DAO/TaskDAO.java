package com.taskManager.storage.DAO;

import com.taskManager.storage.entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDAO {
    void add(Task task) throws SQLException;

    List<Task> getAll() throws SQLException;

    Task getByID(int id) throws SQLException;

    void update(Task task) throws SQLException;

    void remove(Task task) throws SQLException;

    boolean ifExistByName(String name);

}
