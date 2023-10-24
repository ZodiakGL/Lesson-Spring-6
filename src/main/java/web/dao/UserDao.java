package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();

    void addUser (String name, String nickname, String mail);

    void removeUserById(int id);

}
