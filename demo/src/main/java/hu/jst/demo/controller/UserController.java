package hu.jst.demo.controller;


import hu.jst.demo.entity.User;
import hu.jst.demo.entity.UserRegister;
import hu.jst.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public String users() {
        return userService.getUsers().toString();
    }

    @GetMapping ("user/{email}")
    public User searchUsersByName(@PathVariable(value = "email") String userName) {
        return userService.getSpecificUser(userName);
    }

    @PostMapping(value = "user", consumes="application/json")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping(value = "user/{id}", consumes="application/json")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "user/{id}" )
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

}
