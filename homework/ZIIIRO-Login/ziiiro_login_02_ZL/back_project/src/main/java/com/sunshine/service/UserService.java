package com.sunshine.service;

import com.sunshine.domain.data.User;

public interface UserService {
    /**
     * 增：存储一条User信息
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 查：根据用户名/email和密码获取一条记录
     *
     * @param user
     * @return
     */
    User getUserByNameOrEmail(User user);

    /**
     * 删：根据ID删除一条用户信息
     *
     * @param id
     */
    void deleteUserByID(String id);

    /**
     * 改：根据ID更改一条用户信息
     *
     * @param id
     */
    void updateUserByID(String id);
}
