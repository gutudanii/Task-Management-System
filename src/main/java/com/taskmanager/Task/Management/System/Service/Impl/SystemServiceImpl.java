package com.taskmanager.Task.Management.System.Service.Impl;

import com.taskmanager.Task.Management.System.Main.TaskSystem;
import com.taskmanager.Task.Management.System.Main.Users;
import com.taskmanager.Task.Management.System.Repository.SystemRepository;
import com.taskmanager.Task.Management.System.Repository.UsersRepository;
import com.taskmanager.Task.Management.System.Service.SystemService;
import com.taskmanager.Task.Management.System.session.SessionHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SystemServiceImpl implements SystemService {


    @Autowired
    private final SystemRepository repository;

    @Autowired
    final UsersRepository usersRepository;

    @Override
    public void createTask(TaskSystem taskSystem) {
        Users currentUser = usersRepository.findByUsername(SessionHandler.getSession().getUsername()).get();
        taskSystem.setTask_No(12L);
        taskSystem.setUser_Id(currentUser.getId());
        taskSystem.setUsername(currentUser.getUsername());
        taskSystem.setIsTaskIsCompleted(false);
        repository.save(taskSystem);
    }

    @Override
    public void updateTask(Long id, TaskSystem taskSystem) {

            TaskSystem existedTask = repository.findById(id).get();

            existedTask.setId(existedTask.getId());
            existedTask.setTaskTitle(taskSystem.getTaskTitle());
            existedTask.setTaskDescription(taskSystem.getTaskDescription());
            existedTask.setStartDate(taskSystem.getStartDate());
            existedTask.setEndDate(taskSystem.getEndDate());
            existedTask.setIsTaskIsCompleted(existedTask.getIsTaskIsCompleted());
            existedTask.setUser_Id(existedTask.getUser_Id());
            existedTask.setTask_No(taskSystem.getTask_No());

            repository.save(existedTask);
    }

    @Override
    public void deleteTask(Long task_No) {
        repository.deleteById(task_No);
    }

    @Override
    public Optional<TaskSystem> getTask(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TaskSystem> listAllTask(Long user_Id) {
        return repository.findAllById(user_Id);
    }

    @Override
    public void updateIsCompleted(Long id, TaskSystem taskSystem) {

        TaskSystem existedTask = repository.findById(id).get();

        existedTask.setId(existedTask.getId());
        existedTask.setTaskTitle(existedTask.getTaskTitle());
        existedTask.setTaskDescription(existedTask.getTaskDescription());
        existedTask.setStartDate(existedTask.getStartDate());
        existedTask.setEndDate(existedTask.getEndDate());
        existedTask.setIsTaskIsCompleted(true);
        existedTask.setUser_Id(existedTask.getUser_Id());
        existedTask.setTask_No(existedTask.getTask_No());

        repository.save(existedTask);
    }

    @Override
    public void updateIsNotCompleted(Long id, TaskSystem taskSystem) {
        TaskSystem existedTask = repository.findById(id).get();

        existedTask.setId(existedTask.getId());
        existedTask.setTaskTitle(existedTask.getTaskTitle());
        existedTask.setTaskDescription(existedTask.getTaskDescription());
        existedTask.setStartDate(existedTask.getStartDate());
        existedTask.setEndDate(existedTask.getEndDate());
        existedTask.setIsTaskIsCompleted(false);
        existedTask.setUser_Id(existedTask.getUser_Id());
        existedTask.setTask_No(existedTask.getTask_No());

        repository.save(existedTask);
    }

    @Override
    public List<TaskSystem> listAllCompleted(boolean isCompleted) {
        return repository.findByIsTaskIsCompleted(isCompleted);
    }

    @Override
    public List<TaskSystem> listAllNonCompleted(boolean isCompleted) {
        return repository.findByIsTaskIsCompleted(isCompleted);
    }

    public List<TaskSystem> getAllCompletedTasks() {
        List<TaskSystem> completedTasks = new ArrayList<>();
//        List<TaskSystem> allTasks = repository.findAll();

        Users currentUser = usersRepository.findByUsername(SessionHandler.getSession().getUsername()).get();
        List<TaskSystem> taskSystemList = repository.findByUsername(currentUser.getUsername());

        for(TaskSystem task : taskSystemList) {
            if(task.getIsTaskIsCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public List<TaskSystem> getInCompletedTasks() {
        List<TaskSystem> completedTasks = new ArrayList<>();
//        List<TaskSystem> allTasks = repository.findAll();

        Users currentUser = usersRepository.findByUsername(SessionHandler.getSession().getUsername()).get();
        List<TaskSystem> taskSystemList = repository.findByUsername(currentUser.getUsername());
        for(TaskSystem task : taskSystemList) {
            if(!task.getIsTaskIsCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
}
