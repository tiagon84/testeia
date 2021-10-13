package br.com.wedo.testia.controller;

import br.com.wedo.testia.model.User;
import br.com.wedo.testia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        if(!userService.exists(id)){
            throw new IllegalArgumentException();
        }
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
