package springcrud.dao;

import org.springframework.stereotype.Component;
import springcrud.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    
    private static long count;
    private final List<User> userList;
    
    public UserDaoImpl() {
        userList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            count++;
            userList.add(
                    new User(
                            count,
                            "name-" + count,
                            "surname-" + count,
                            (int) (Math.random() * 50 + 1950)
                    )
            );
        }
    }
    
    @Override
    public List<User> getAll() {
        return userList;
    }
    
    @Override
    public User getById(long id) {
        return null;
    }
    
    @Override
    public void save(User user) {
    
    }
    
    @Override
    public void update(User user) {
    
    }
    
    @Override
    public void deleteById(long id) {
    
    }
}
