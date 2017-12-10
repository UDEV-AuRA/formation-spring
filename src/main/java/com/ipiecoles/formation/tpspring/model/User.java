package com.ipiecoles.formation.tpspring.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    private Long id;
    @Column
    private String login;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToMany
    @JoinTable(name = "user_films_avoir", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_film"))
    private Set<Film> filmsAVoir = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "user_films_vus", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_film"))
    private Set<Film> dejaVus = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Film> getFilmsAVoir() {
        return filmsAVoir;
    }

    public void setFilmsAVoir(Set<Film> filmsAVoir) {
        this.filmsAVoir = filmsAVoir;
    }

    public Set<Film> getDejaVus() {
        return dejaVus;
    }

    public void setDejaVus(Set<Film> dejaVus) {
        this.dejaVus = dejaVus;
    }

    @Override
    public String toString() {
        return login;
    }
}
