package springcrud.services;

import org.springframework.stereotype.Service;
import springcrud.dao.UserDao;
import springcrud.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
    
    public User getUserById(long id) {
        return userDao.getById(id);
    }
    
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }
    
    @Override
    public void updateUser(long id, User newUser) {
        newUser.setId(id);
        userDao.update(newUser);
    }
    
    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }
}
