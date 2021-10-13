package br.com.wedo.testia;

import br.com.wedo.testia.model.User;
import br.com.wedo.testia.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@Log
public class TestiaApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TestiaApplication.class, args);
    }

    @Bean
    ApplicationRunner dbLoad() {
        return args -> {
            log.info("*** LOADING DATA ***");
            userService.saveAll(Arrays.asList(
                    new User("cartman", passwordEncoder.encode("123"), "cartman@sp.com", "Eric Cartman", false),
                    new User("stan", passwordEncoder.encode("123"), "stan@sp.com", "Stan Marsh", false),
                    new User("kyle", passwordEncoder.encode("123"), "kyle@sp.com", "Kyle Broflovski", false),
                    new User("kenny", passwordEncoder.encode("123"), "kenny@sp.com", "Kenny McCormick", false),
                    new User("butters", passwordEncoder.encode("123"), "butters@sp.com", "Butters Stotch", false),
                    new User("chef", passwordEncoder.encode("123"), "chef@sp.com", "Chef", true)
            ));
        };
    }
}
