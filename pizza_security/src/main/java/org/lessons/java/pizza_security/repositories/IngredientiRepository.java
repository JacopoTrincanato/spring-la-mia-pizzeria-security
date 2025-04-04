package org.lessons.java.pizza_security.repositories;

import org.lessons.java.pizza_security.models.Ingredienti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientiRepository extends JpaRepository<Ingredienti, Integer> {

}
