package org.lessons.java.pizza_security.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ruolo")
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il campo nome non può essere vuoto o null")
    private String nome;

    // creo la relazione ManyToMany
    @ManyToMany(mappedBy = "ruoli", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<User> utenti;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<User> getUtenti() {
        return this.utenti;
    }

    public void setUtenti(Set<User> utenti) {
        this.utenti = utenti;
    }

}
