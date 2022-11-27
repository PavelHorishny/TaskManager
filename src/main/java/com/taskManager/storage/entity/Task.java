package com.taskManager.storage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TASK")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue()
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date createdDateTime;

    @Column(name = "end_date")
    private Date finishedDateTime;

    @Column(name = "time")
    private int sTime;

}
