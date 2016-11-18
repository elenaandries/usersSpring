package users.service.implementation;

import org.springframework.stereotype.Service;
import users.model.User;
import java.util.List;

/**
 * Created by ebastic on 11/17/2016.
 */
@Service
public interface UserImplementation {

    User createUser(User user);
    List<User> getUsers();
    User updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
}