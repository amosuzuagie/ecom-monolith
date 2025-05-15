package com.app.ecom.service;

import com.app.ecom.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> userList = new ArrayList<>();
    private long idCount = 1L;

    public List<User> fetchAllUser() {
        return userList;
    }

    public void addUser(User user) {
        user.setId(idCount++);
        userList.add(user);
    }


    public Optional<User> fetchUser(long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public boolean updateUser(long id, User userUpdate) {
        return userList.stream()
                .filter( user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setLastName(userUpdate.getLastName());
                    existingUser.setFirstName(userUpdate.getFirstName());
                    return true;
                }).orElse(false);
    }
}
