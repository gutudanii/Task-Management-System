package com.taskmanager.Task.Management.System.Main;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // TASK MANAGER
    private String taskTitle;
    private String taskDescription;

    private String startDate;
    private String endDate;

    private Boolean isTaskIsCompleted;

    //OWNER
    private Long user_Id;
    private Long task_No;
    private String username;
}
