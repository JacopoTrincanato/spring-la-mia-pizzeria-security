package org.lessons.java.pizza_security.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "utente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il campo username non può essere vuoto o null")
    private String username;

    @NotBlank(message = "Il campo password non può essere vuoto o null")
    @Size(min = 8, max = 30, message = "la password deve essere lunga almeno 8 caratteri e non più di 30")
    private String password;

    // implemento la relazione ManyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ruolo_utente", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "ruolo_id"))
    private Set<Ruolo> ruoli;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ruolo> getRuoli() {
        return this.ruoli;
    }

    public void setRuoli(Set<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }

}
