package com.taskmanager.Task.Management.System.Controller;


import com.taskmanager.Task.Management.System.Mail.mailSenderService;
import com.taskmanager.Task.Management.System.Main.TaskSystem;
import com.taskmanager.Task.Management.System.Main.Users;
import com.taskmanager.Task.Management.System.Repository.SystemRepository;
import com.taskmanager.Task.Management.System.Repository.UsersRepository;
import com.taskmanager.Task.Management.System.Service.Impl.SystemServiceImpl;
import com.taskmanager.Task.Management.System.session.SessionHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@ComponentScan
@AllArgsConstructor
@RequestMapping(path = {"/tasks"})
public class SystemController {
        @Autowired
        private SystemRepository taskRepository;

        @Autowired
        private final UsersRepository usersRepository;

        @Autowired
        private SystemServiceImpl service;

        @Autowired
        private mailSenderService mailSenderService;

    // Display list of all tasks By Their Username
    @RequestMapping(path = {""})
    public String showAllTasks(Model model) {
        Users users = usersRepository.findByUsername(SessionHandler.getSession().getUsername()).get();
        List<TaskSystem> taskSystemList = taskRepository.findByUsername(users.getUsername());
//        try {
//            mailSenderService.mailSender(users.getEmail(), users.getName());
//            System.out.println("Email is sent successfully");
//        }
//        catch (Exception e){
//            System.out.println("Error is Occurred");
//        }

        model.addAttribute("tasks", taskSystemList);
        return "task-list";
    }


    // Show task creation form
        @GetMapping("/new")
        public String showCreateTaskForm(Model model) {
            model.addAttribute("task", new TaskSystem());
            return "create-task";
        }

    // Create new task
        @PostMapping("/save")
        public String createTask(@Valid TaskSystem task, BindingResult result) {
            if (result.hasErrors()) {
                return "create-task";
            }
//            System.out.println(task.getStartDate());

                service.createTask(task);
                return "redirect:/tasks";
        }



        //UPDATE TASK
        @GetMapping("/update/{id}")
        public String editTaskForm(@PathVariable("id") Long id, Model model) {
            TaskSystem task = service.getTask(id).get();
            model.addAttribute("task", task);
            System.out.println("Task " + task.getId());
            return "update-task";
        }
       @PostMapping("{id}/edit")
         public String updateTask(@PathVariable("id") Long id, @ModelAttribute("task") TaskSystem task, BindingResult result) {
            if (result.hasErrors()) {
            return "update-task";
        }
            System.out.println(id);
        service.updateTask(id,task);
        return "redirect:/tasks";
    }
    @RequestMapping(path = {"isCompleted","{id}/isCompleted"})
    public String isCompleted(@PathVariable("id") Long id,
                              @ModelAttribute("task") TaskSystem task){
        task.setIsTaskIsCompleted(true);
        service.updateIsCompleted(id,task);
        return "redirect:/tasks";
    }
    @RequestMapping(path = {"isNotCompleted","{id}/isNotCompleted"})
    public String isNotCompleted(@PathVariable("id") Long id,
                              @ModelAttribute("task") TaskSystem task){
        task.setIsTaskIsCompleted(false);
        service.updateIsNotCompleted(id,task);
        return "redirect:/tasks";
    }

        //DELETE TASK
        @RequestMapping(path = {"delete", "/delete/{id}"})
        public String deleteTasks(@PathVariable("id") Long id){
            service.deleteTask(id);
            return "redirect:/tasks";
        }

        @GetMapping("/get/allCompleted")
        public String getAllCompletedTasks(Model model) {
        List<TaskSystem> completedTasks = service.getAllCompletedTasks();
        model.addAttribute("tasks", completedTasks);
        return "all-completed";
    }

        @GetMapping("/get/inCompleted")
        public String getInCompletedTasks(Model model) {
        List<TaskSystem> completedTasks = service.getInCompletedTasks();
        model.addAttribute("tasks", completedTasks);
        return "in-completed";
    }


}

