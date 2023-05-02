package com.taskmanager.Task.Management.System.Repository;

import com.taskmanager.Task.Management.System.Main.TaskSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemRepository extends JpaRepository<TaskSystem, Long>{
    List<TaskSystem> findAllById(Long user_Id);
    List<TaskSystem> findByIsTaskIsCompleted(boolean isTaskIsCompleted);
    List<TaskSystem> findByUsername(String username);

}

