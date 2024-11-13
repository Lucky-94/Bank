package service;

import model.User;

import java.util.List;

public interface UserService {
    boolean registerUser(String email, String password, String name, String userId, String role);
    User login(String email, String password);
    List<User> viewUser();
    boolean deleteUser(String userId);


}
