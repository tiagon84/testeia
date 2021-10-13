package br.com.wedo.testia.config.security.service;

import br.com.wedo.testia.config.security.model.AppUserDetails;
import br.com.wedo.testia.model.User;
import br.com.wedo.testia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new AppUserDetails(
                Optional.ofNullable(userRepository.findByLogin(login)).orElseThrow(IllegalArgumentException::new)
        );
    }
}
