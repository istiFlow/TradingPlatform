package hu.jst.demo.controller;


import hu.jst.demo.entity.User;
import hu.jst.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public String users() {
        return userService.getUsers().toString();
    }

    @GetMapping ("user/{name}")
    public User searchUsersByName(@PathVariable(value = "name") String userName) {
        return userService.getSpecificUser(userName);
    }

    @PostMapping(value = "user", consumes="application/json")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping(value = "user/{id}" )
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

}
