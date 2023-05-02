package com.taskmanager.Task.Management.System.Service.Impl;

import com.taskmanager.Task.Management.System.Main.Users;
import com.taskmanager.Task.Management.System.Repository.UsersRepository;
import com.taskmanager.Task.Management.System.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    final UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users createUser(Users users) {
        String encodedPass = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPass);

        return usersRepository.save(users);
    }
}
