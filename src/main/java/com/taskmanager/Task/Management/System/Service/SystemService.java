package com.taskmanager.Task.Management.System.Service;


import com.taskmanager.Task.Management.System.Main.TaskSystem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SystemService{
         void createTask(TaskSystem taskSystem);
         void updateTask(Long id, TaskSystem taskSystem);
         void deleteTask(Long task_No);
         Optional<TaskSystem> getTask(Long id);
         List<TaskSystem> listAllTask(Long user_Id);

         void updateIsCompleted(Long id, TaskSystem taskSystem);
        void updateIsNotCompleted(Long id, TaskSystem taskSystem);

    List<TaskSystem> listAllCompleted(boolean isCompleted);
         List<TaskSystem> listAllNonCompleted(boolean isCompleted);
}
