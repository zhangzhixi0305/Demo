package com.zhixi.service;

import com.zhixi.domain.User;

/**
 * @author zhangzhixi
 */
public interface UserService {
    public User login(String name, String pass);

    public boolean insert(User entity);

    public boolean delete(User entity);

    public boolean update(User entity);

    public User findByName(String name);

}
