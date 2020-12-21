package com.zhixi.dao;

import com.zhixi.domain.User;

public interface UserDao {
    public User login(String name, String pass);

    public boolean insert(User entity);

    public boolean delete(User entity);

    public boolean update(User entity);

    public User findByName(String name);

}

