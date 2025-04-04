package org.lessons.java.pizza_security.security;

import java.util.Optional;

import org.lessons.java.pizza_security.models.User;
import org.lessons.java.pizza_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userAttempt = userRepository.findByUsername(username);

        // se non trova lo username, lancia un'eccezione di tipo
        // UsernameNotFoundException
        if (userAttempt.isEmpty()) {
            throw new UsernameNotFoundException("Non sono presenti utenti con quell'username");
        }

        // ritorna un nuovo utente
        return "";

    }
}
