package hu.jst.demo.service;


import hu.jst.demo.entity.User;
import hu.jst.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@Service
//@EnableWebSecurity
@CrossOrigin(origins = "http://localhost:4200")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //LOGIN
    public Boolean login(String email, String password) {
        User temp = userRepository.findByEmail(email);
        if(temp != null) {
            if(passwordEncoder.matches(password, temp.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //READ
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //READ
    public User getSpecificUser(String email) {
        return userRepository.findByEmail(email);
    }

    //CREATE
    public User saveUser(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //UPDATE
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //DELETE
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    //EXIST
    public int userIsExist(String email) { return userRepository.isExist(email);}

}
