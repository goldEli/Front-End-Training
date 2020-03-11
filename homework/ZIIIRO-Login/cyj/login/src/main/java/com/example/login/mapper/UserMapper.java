package com.example.login.mapper;

import com.example.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface UserMapper {
    public User findUserById(int id);
    public User findUserByName(String name);
    List<User> findAll();
    public int insertUser(User user);
}
