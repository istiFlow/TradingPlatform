package hu.jst.demo.service;


import hu.jst.demo.entity.User;
import hu.jst.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //READ
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    //READ
    public User getSpecificUser(String userName) {
        return userRepository.findByName(userName);
    }

    //CREATE
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //UPDATE
    public User updateUser(Long id, User user) {
        userRepository.deleteById(id);
        return userRepository.save(user);
    }

    //DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
