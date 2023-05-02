package com.taskmanager.Task.Management.System.Service;

import com.taskmanager.Task.Management.System.Main.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Users createUser(Users users);

}
