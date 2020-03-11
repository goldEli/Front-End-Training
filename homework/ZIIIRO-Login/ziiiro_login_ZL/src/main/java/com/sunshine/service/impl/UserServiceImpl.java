package com.sunshine.service.impl;

import com.sunshine.dao.UserDao;
import com.sunshine.domain.data.User;
import com.sunshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户信息：进行业务判断（同名判断）
     *
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    /**
     * 查询用户信息：进行业务判断（表单回显 + 登录状态判断：成功 + 密码错误？ + 账号错误？）
     *
     * @param user
     * @return
     */
    @Override
    public User getUserByNameOrEmail(User user) {
        String username = user.getUsername();
        if (username == null){
            String email = user.getEmail();
            return userDao.getUserByNameOrEmail(email, email);
        }
        return userDao.getUserByNameOrEmail(username, username);
    }

    @Override
    public void deleteUserByID(String id) {

    }

    @Override
    public void updateUserByID(String id) {

    }
}
