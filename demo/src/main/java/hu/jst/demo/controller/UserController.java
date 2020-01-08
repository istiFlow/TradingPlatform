package hu.jst.demo.controller;


import hu.jst.demo.entity.Auth;
import hu.jst.demo.entity.User;
import hu.jst.demo.entity.UserRegister;
import hu.jst.demo.repository.UserRepository;
import hu.jst.demo.service.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.json.JSONString;
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


    @GetMapping(value = "user/{email}")
    public User findUserByEmail(@PathVariable String email) {
        if(userService.userIsExist(email) == 1) {
            return userService.getSpecificUser(email);
        }
        return null;
    }

    @PostMapping(value = "/user/login", consumes="application/json")
    public Auth createUserValidation(@RequestBody User item) {
        User temp = userService.getSpecificUser(item.getEmail());
        if(passwordEncoder.matches(item.getPassword(), temp.getPassword())){
            Auth response = new Auth("OK");
            return response;
        }
            Auth response = new Auth("NO");
            return response;

    }

/*    @PostMapping(value = "/user/login", consumes="application/json")
    public Auth createUserValidation2(@RequestBody User item) {
        User temp = userService.getSpecificUser(item.getEmail());
        if(item.getPassword().equals(temp.getPassword())){
            Auth response = new Auth("OK");
            return response;
        }
        Auth response = new Auth("WRONG");
        return response;

    }*/

    @PostMapping(value = "register" /*consumes="application/json"*/)
    public String createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "Hi " + user.getEmail() + " your registration process succesfully completed";
    }

    @PutMapping(value = "user" /*consumes="application/json"*/)
    public User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

/*    @DeleteMapping(value = "user/{id}" )
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUser(id);
    }*/

    @DeleteMapping(value = "user/{email}")
    public Auth deleteUser(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        if (userService.getSpecificUser(email) == null) {
            Auth response = new Auth("OK");
            return response;
        }
        Auth response = new Auth("WRONG");
        return response;
    }

}
