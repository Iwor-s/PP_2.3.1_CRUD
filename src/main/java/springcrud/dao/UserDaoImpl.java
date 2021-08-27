package springcrud.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import springcrud.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;
    
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .getResultList();
    }
    
    @Override
    @Transactional
    public User getById(long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }
    
    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    
    @Override
    @Transactional
    public void update(long id, User newUser) {
        User oldUser = getById(id);
        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());
        oldUser.setYearOfBirth(newUser.getYearOfBirth());
        sessionFactory.getCurrentSession().update(oldUser);
    }
    
    @Override
    @Transactional
    public void deleteById(long id) {
        sessionFactory.getCurrentSession().delete(getById(id));
    }
}
