package com.taskManager.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
    private Method method; //1.GET DATA FROM DB 2.POST DATA TO DB 3.PUT AND DELETE
    private int id;
    private String name;
    private int time;
    private String finished;
}
