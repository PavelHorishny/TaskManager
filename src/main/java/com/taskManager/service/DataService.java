package com.taskManager.service;

import com.taskManager.exception.BadRequestException;
import com.taskManager.exception.AlreadyExistException;
import com.taskManager.DTO.Request;
import com.taskManager.DTO.Response;
import com.taskManager.DTO.Status;
import com.taskManager.storage.entity.Task;
import com.taskManager.storage.service.TaskService;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DataService {
    TaskService taskService = new TaskService();

    public Response requestResolve(Request request) {
        switch (request.getMethod()) {
            case GET:
                System.out.println("get");
                return resolveGet(request.getId());
            case POST:
                System.out.println("post");
                return resolvePost(request.getName());
            case PUT:
                System.out.println("put");
                return resolvePut(request.getId(), request.getName(), request.getFinished(), request.getTime());
            case DELETE:
                System.out.println("delete");
                return resolveDelete(request.getId());
            default:
                System.out.println("bad request");
                return new Response(Status.BAD,new BadRequestException("Bad request"),null);
        }
    }

    private Response resolveDelete(int id) {
        try {
            taskService.remove(taskService.getByID(id));
            return new Response(Status.OK, null, null);
        } catch (SQLException | NoResultException e) {

            return new Response(Status.BAD, e, null);

        } finally {
            taskService.closeTransactionSession();
        }

    }

    //TODO test resolve put method
    //TODO make warnings in case of non critical troubles
    private Response resolvePut(int id, String name, String finish, int time) {
        try {
            Task task = taskService.getByID(id);
            if (name != null) {
                task.setName(name);
            }
            if (finish != null && task.getFinishedDateTime()==null) {
                task.setFinishedDateTime(new Date());
            }
            if (time > task.getSTime()) {
                task.setSTime(time);
            }
            taskService.update(task);
            return new Response(Status.OK, null, null);
        } catch (SQLException | NoResultException e) {
            return new Response(Status.BAD, e, null);
        }
    }

    private Response resolvePost(String name) {

        if (!taskService.ifExistByName(name)) {
            taskService.closeTransactionSession();
            try {
                taskService.add(Task.builder().name(name).createdDateTime(new Date()).sTime(0).build());
                return new Response(Status.OK, null, null);
            } catch (SQLException e) {
                e.printStackTrace();
                taskService.closeTransactionSession();
                return new Response(Status.BAD, e, null);
            }
        } else {
            return new Response(Status.BAD, new AlreadyExistException("Already exist"), null);
        }
    }

    private Response resolveGet(int id) {
        List<Task> tasks = new ArrayList<>();
        if (id == 0) {
            try {
                tasks = taskService.getAll();
                return new Response(Status.OK, null, tasks);
            } catch (SQLException | NoResultException e) {
                return new Response(Status.BAD, e, tasks);
            }
        } else {
            try {
                tasks = new ArrayList<>();
                Task t = taskService.getByID(id);
                tasks.add(t);
                return new Response(Status.OK, null, tasks);
            } catch (SQLException | NoResultException e) {
                return new Response(Status.BAD, e, tasks);
            } finally {
                taskService.closeTransactionSession();
            }
        }
    }
}
