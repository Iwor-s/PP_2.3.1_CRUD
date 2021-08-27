package springcrud.services;

import springcrud.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);
    void updateUser(long id, User newUser);
    void deleteUserById(long id);
}
