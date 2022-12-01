package com.taskManager.storage.service;

import com.taskManager.storage.DAO.TaskDAO;
import com.taskManager.storage.entity.Task;
import com.taskManager.storage.utillity.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class TaskService extends SessionUtil implements TaskDAO {
    @Override
    public void add(Task task) throws SQLException {

        openTransactionSession();
        Session session = getSession();
        session.save(task);
        closeTransactionSession();
    }

    @Override
    public List<Task> getAll() throws SQLException {

        openTransactionSession();
        String sql = "SELECT * FROM TASK";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Task.class);
        List<Task> tasks = query.list();
        closeTransactionSession();
        return tasks;
    }

    @Override
    public Task getByID(int id) throws SQLException {

        openTransactionSession();
        String sql = "SELECT * FROM TASK WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Task.class);
        query.setParameter("id", id);
        Task task = (Task) query.getSingleResult();

        closeTransactionSession();

        return task;
    }

    @Override
    public void update(Task task) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(task);

        closeTransactionSession();
    }

    @Override
    public void remove(Task task) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(task);

        closeTransactionSession();
    }

    @Override
    public boolean ifExistByName(String name) {

        String sql = "SELECT * FROM TASK WHERE NAME = :name";
        try {
            openTransactionSession();
            Session session = getSession();

            Query query = session.createNativeQuery(sql).addEntity(Task.class);
            query.setParameter("name", name);
            Task task = (Task) query.getSingleResult();

            closeTransactionSession();

            return true;
        } catch (NoResultException e) {
            return false;
        }

    }
}
