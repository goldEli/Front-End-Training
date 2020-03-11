package com.example.login.service;

import com.example.login.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public boolean login(User user);

    public int insertUser(User user);
}
