package com.sunshine.service.impl;

import com.sunshine.dao.UserDao;
import com.sunshine.domain.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void test01(){
        User xxx = new User("XXX", "123456", "1235648@qq.com");
        User save = userDao.save(xxx);
        System.out.println(save);
    }
    @Test
    public void test02(){
        User one = userDao.getOne("8a808a9e70c2fc680170c2fe36d20001");
        System.out.println(one);
    }
}