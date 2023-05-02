package com.taskmanager.Task.Management.System.Controller;

import com.taskmanager.Task.Management.System.Main.Users;
import com.taskmanager.Task.Management.System.Repository.UsersRepository;
import com.taskmanager.Task.Management.System.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(path = {"/tasks"})
public class UsersController {

    @Autowired
    final UsersService usersService;

    @Autowired
    final UsersRepository usersRepository;


    @PostMapping("/register/save")
    public String createUser(@ModelAttribute @RequestBody Users users, Model model){
       try {
           boolean userExist = usersRepository
                   .findByUsername(users.getUsername())
                   .isPresent();
//           System.out.println(userExist);
           if (userExist) {
               throw new IllegalStateException(String.format("Username is already registered " + users.getUsername()));
           }

           else {
               usersService.createUser(users);
           }
           model.addAttribute("users", users);
       }
       catch (Exception e){
           return "/Error";
       }

        return "login-page";
    }

    @GetMapping("/register")
    public String getRegister( Users users, Model model){
        model.addAttribute("users", users);
        return "register-page";
    }

    @GetMapping("/Error")
    public String getRegisterError( Users users, Model model){
        model.addAttribute("users", users);
        return "Error";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login-page";
    }
    @RequestMapping(path = {"/login-page-error"})
    public String getLoginPageError(){
        return "login-page-error";
    }
    @GetMapping("/logout-handler")
    public String getLogout(){
        return "logout-handler";
    }

}
