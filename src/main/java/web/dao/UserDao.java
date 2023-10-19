package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();
}
