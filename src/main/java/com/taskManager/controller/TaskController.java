package com.taskManager.controller;

import com.taskManager.DTO.Method;
import com.taskManager.DTO.Request;
import com.taskManager.DTO.Response;

import com.taskManager.service.DataService;



public class TaskController {

    DataService dataService = new DataService();

    public Response get(int id){
        return dataService.requestResolve(Request.builder().method(Method.GET).id(id).build());
    }

    public Response post(String name){
        return dataService.requestResolve(Request.builder().method(Method.POST).name(name).build());
    }

    public Response put(int id,String name,String finish,int time){
        return dataService.requestResolve(Request.builder().method(Method.PUT).id(id).name(name).finished(finish).time(time).build());
    }

    public Response delete(int id){
        return dataService.requestResolve(Request.builder().method(Method.DELETE).id(id).build());
    }
}
