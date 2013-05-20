package grow.user;

import grow.entities.User;

import java.util.List;


@SuppressWarnings("rawtypes")
public interface UserDao extends Dao {

    User findById(Long id);

    User findByUsername(String username);

    List<?> findByEmail(String email);

    List<?> findAll();

    void save(User user);

    void delete(User user);
}