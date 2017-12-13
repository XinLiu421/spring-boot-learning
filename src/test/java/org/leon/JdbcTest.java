package org.leon;


import javafx.application.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.leon.entity.User;
import org.leon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTest {

    @Autowired
    UserService userService;

    @Before
    public void init() {
        userService.deleteAll();
    }

    @Test
    public void test() {
        //add user
        userService.createUser(18, "a");
        userService.createUser(19, "b");
        userService.createUser(20, "c");

        // count
        Assert.assertEquals(3, userService.getAllUsers().intValue());

        //is current user
        User user = new User();
        user.setAge(19);
        user.setName("b");
        Assert.assertEquals(user.getName(), userService.findByName("b").getName());

        //delete user
        userService.deleteByName("a");

        //count
        Assert.assertEquals(2, userService.getAllUsers().intValue());

        //delete all
        userService.deleteAll();

        //count
        Assert.assertEquals(0, userService.getAllUsers().intValue());

    }

}
