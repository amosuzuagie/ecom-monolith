package com.app.ecom.service;

import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> fetchAllUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    public Optional<User> fetchUser(long id) {
        return userRepository.findById(id);
    }

    public boolean updateUser(long id, User userUpdate) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setLastName(userUpdate.getLastName());
                    user.setFirstName(userUpdate.getFirstName());
                    userRepository.save(user);
                    return true;
                }).orElse(false);
    }
}
