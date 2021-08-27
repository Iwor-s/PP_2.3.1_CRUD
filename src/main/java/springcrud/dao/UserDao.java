package springcrud.dao;

import springcrud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void update(long id, User newUser);
    void deleteById(long id);
}
