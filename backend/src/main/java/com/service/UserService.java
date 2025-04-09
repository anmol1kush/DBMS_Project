package com.hotelhub.service;

import com.hotelhub.dao.UserDAO;
import com.hotelhub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }
    public Integer getGuestIdByUserId(int userId) {
        return userDAO.getGuestIdByUserId(userId);
    }
    

    public User addUser(User user) {
        return userDAO.addUser(user);
    }
    

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }
    public User authenticateUser(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }
    

    public int deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }
}

