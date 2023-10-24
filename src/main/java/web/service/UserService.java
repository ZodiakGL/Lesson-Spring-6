package web.service;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.List;

@Component
public interface UserService {
    List<User> getAllUsers();

    void addUser(String name, String nickname, String mail);
}
