package org.lessons.java.pizza_security.repositories;

import java.util.Optional;

import org.lessons.java.pizza_security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // metodo che implementa il recupero tramite username
    public Optional<User> findByUsername(String username);
}
