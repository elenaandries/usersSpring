package users.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import users.model.User;
import users.service.implementation.UserImplementation;
import java.util.ArrayList;
import java.util.HashMap;;
import java.util.List;

/**
 * Created by ebastic on 11/16/2016.
 */
@Service
public class UserService implements UserImplementation {

    private static HashMap<Integer, User> userMap = getCountryIdMap();

    public static HashMap<Integer, User> getCountryIdMap() {
        return userMap;
    }

    public UserService() {
        if (userMap == null) {
            userMap = new HashMap<>();
            User u1 = new User(1, "junior", "ramona");
            User u2 = new User(2, "junior", "elena");
            User u3 = new User(3, "senior", "maria");
            User u4 = new User(4, "junior","serena");
            userMap.put(1, u1);
            userMap.put(2, u2);
            userMap.put(3, u3);
            userMap.put(4, u4);
        }
    }

    @Override
    public User createUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>(userMap.values());
        return users;
    }

    @Override
    public User updateUser(@RequestBody User user) {
        if (user.getId() <= 0) {
            return null;
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUser(@PathVariable int id) {
        userMap.remove(id);
    }

    @Override
    public User getUserById(int id) {
        User user = userMap.get(id);
        return user;
    }
}
