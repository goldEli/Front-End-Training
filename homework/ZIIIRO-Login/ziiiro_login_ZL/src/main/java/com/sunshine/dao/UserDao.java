package com.sunshine.dao;

import com.sunshine.domain.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, String> {

    /**
     * 自定义SQL查询语句：用于登录信息验证
     *
     * @param username
     * @param email
     * @return
     */
    @Query(value = "select * from user where username=? or email=?", nativeQuery = true)
    User getUserByNameOrEmail(String username, String email);
}
