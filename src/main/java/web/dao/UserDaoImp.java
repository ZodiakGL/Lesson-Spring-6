package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers () {
        String jpql = "SELECT e FROM User e";
        List<User> users = entityManager.createQuery(jpql, User.class).getResultList();
        return users;
    }
}
