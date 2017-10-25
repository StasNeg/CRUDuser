package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User get(Long id);

    void delete(Long id);

    User save(User user);

    List<User> getByFilter(String email, String firstName, String lastName);



}
