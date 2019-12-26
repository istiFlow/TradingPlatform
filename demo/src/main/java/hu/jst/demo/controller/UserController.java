package hu.jst.demo.controller;


import hu.jst.demo.entity.User;
import hu.jst.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("users")
    public String users() {
        return userService.getUsers().toString();
    }

    @RequestMapping("user/{name}")
    public User searchUsersByName(@PathVariable(value = "name") String userName) {
        return userService.getSpecificUser(userName);
    }

}
