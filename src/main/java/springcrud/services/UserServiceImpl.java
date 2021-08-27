package springcrud.services;

import org.springframework.stereotype.Service;
import springcrud.dao.UserDao;
import springcrud.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
    
    public List<User> getUserById(int id) {
        List<User> list = new ArrayList<>();
        list.add(userDao.getById(id));
        return list;
    }
}
