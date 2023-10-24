package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public void addUser(String name, String nickname, String mail) {

            Query query = entityManager.createQuery("INSERT into User (name, nickname, mail) VALUES (:name, :nickname, :mail)");
            query.setParameter("name", name);
            query.setParameter("nickname", nickname);
            query.setParameter("mail", mail);
            query.executeUpdate();
    }

    @Override
    public void removeUserById(int id) {

    }
}
