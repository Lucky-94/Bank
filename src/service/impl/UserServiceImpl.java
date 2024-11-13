package service.impl;

import model.Admin;
import model.Customer;
import model.Role;
import model.User;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private User currentUser;
    private final Map<String,User> users;

    private static UserServiceImpl INSTANCE;


    private UserServiceImpl() {
        this.users = new HashMap<>();
    }
    public static UserServiceImpl getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public boolean registerUser(String email, String password, String name, String userId, String role) {
        if (currentUser == null || !currentUser.getRole().equals(Role.ADMIN)) {
            return false;
        }
        if (!isValidEmail(email) || !isValidPassword(password)) {
            return false;
        }
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        User newUser;
        if(role.equals("Admin")){
            newUser = new Admin(userId, name, email, password);
        }
        else{
            newUser = new Customer(userId, name, email, password);
        }
        users.put(newUser.getUserId(),newUser);
        return true;
    }
    @Override
    public User login(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)){ currentUser = user;}
        return user;
    }

    @Override
    public List<User> viewUser() {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");

    }
    private boolean isValidPassword(String password){
        return password != null && password.length()>=6;
    }
}
