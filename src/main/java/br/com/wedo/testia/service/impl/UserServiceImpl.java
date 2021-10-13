package br.com.wedo.testia.service.impl;

import br.com.wedo.testia.model.User;
import br.com.wedo.testia.repository.UserRepository;
import br.com.wedo.testia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(Collection<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public void deleteUser(Long id) {
        var u = userRepository.getById(id);
        userRepository.delete(u);
    }

    @Override
    public boolean exists(Long id) {
        return userRepository.existsById(id);
    }
}
