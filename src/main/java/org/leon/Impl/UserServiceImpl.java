package org.leon.Impl;

import org.leon.entity.User;
import org.leon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate template;

    @Override
    public void createUser(Integer age, String name) {
        template.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public User findByName(String name) {
        return template.queryForObject("select * from user where name = ?", new Object[] {name}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Integer getAllUsers() {
        return template.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public  void deleteAll() {
        template.update("delete from user");
    }

    @Override
    public void deleteByName(String name) {
        template.update("delete from USER where NAME = ?", name);
    }

}
