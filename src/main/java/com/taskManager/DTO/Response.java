package com.taskManager.DTO;

import com.taskManager.storage.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    Status status;
    Exception exception;
    List<Task> tasks;
}
