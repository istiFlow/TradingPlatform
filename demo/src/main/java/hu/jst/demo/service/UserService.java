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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getSpecificUser(String userName) {
        return userRepository.findByName(userName);
    }

}
