package hu.jst.demo.controller;


import hu.jst.demo.entity.Auth;
import hu.jst.demo.entity.User;
import hu.jst.demo.entity.UserRegister;
import hu.jst.demo.repository.UserRepository;
import hu.jst.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("users")
    public String users() {
        return userService.getUsers().toString();
    }

/*    @GetMapping("login")
    @CrossOrigin(origins = "http://localhost:4200")
    public String userLogin() {
            //if(userService.login)
            return userService.getUsers().toString();
    }*/

/*    //LOGIN
    public Boolean login(String email, String password) {
        User temp = userRepository.findByEmail(email);
        if(temp != null) {
            if(passwordEncoder.matches(password, temp.getPassword())) {
                return true;
            }
        }
        return false;
    }*/

    @GetMapping ("user/{email}&{password}")
    public Auth searchUsersByName(@PathVariable String email, @PathVariable String password) {
        User temp = userService.getSpecificUser(email);
        if(temp != null) {
            if(passwordEncoder.matches(password, temp.getPassword())) {
                Auth response = new Auth("OK");
                return response;
            }
        }
        Auth response = new Auth("NO");
        return response;
    }

    @PostMapping(value = "register" /*consumes="application/json"*/)
    public String createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        //userRepository.save(user);
        return "Hi " + user.getEmail() + " your registration process succesfully completed";
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
