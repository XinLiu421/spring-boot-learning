package org.leon.controller;

import org.leon.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(u.getId(), u);
        return "success";
    }

    @RequestMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
