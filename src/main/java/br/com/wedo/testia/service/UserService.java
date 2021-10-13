package br.com.wedo.testia.service;

import br.com.wedo.testia.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface UserService {

    List<User> getAll();
    User get(Long id);
    User save(User user);
    List<User> saveAll(Collection<User> users);
    void deleteUser(Long id);
    boolean exists(Long id);

}
