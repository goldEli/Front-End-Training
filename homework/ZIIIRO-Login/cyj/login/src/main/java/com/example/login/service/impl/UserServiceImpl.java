package com.example.login.service.impl;

import com.example.login.entity.User;
import com.example.login.mapper.UserMapper;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean login(User user) {
        String name = user.getName();
        String password = user.getPassword();
        User u = userMapper.findUserByName(name);
        if (u == null){
            return false;
        }else {
            if (u.getPassword().equals(password)){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
