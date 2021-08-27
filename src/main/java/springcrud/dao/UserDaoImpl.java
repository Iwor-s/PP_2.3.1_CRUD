package springcrud.dao;

import org.springframework.stereotype.Component;
import springcrud.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private final List<User> userList;
    private static long count;
    
    public UserDaoImpl() {
        userList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            User user = new User();
            user.setId(++count);
            user.setName("Name-" + count);
            user.setSurname("Surname-" + count);
            user.setYearOfBirth((int) (Math.random() * 50 + 1950));
            userList.add(user);
        }
    }
    
    @Override
    public List<User> getAll() {
        return userList;
    }
    
    @Override
    public User getById(long id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findAny().orElse(null);
    }
    
    @Override
    public void save(User user) {
        if (user.getId() == 0)
            user.setId(++count);
        userList.add(user);
    }
    
    @Override
    public void update(long id, User newUser) {
        User oldUser = getById(id);
        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());
        oldUser.setYearOfBirth(newUser.getYearOfBirth());
    }
    
    @Override
    public void deleteById(long id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
