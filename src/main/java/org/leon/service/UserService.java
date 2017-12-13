package org.leon.service;

import org.leon.entity.User;

public interface UserService {

    //新建user
    void createUser(Integer age, String name);

    //根据名字查询
    User findByName(String name);

    //删除所有
    void deleteAll();

    Integer getAllUsers();

    void deleteByName(String name);
}
