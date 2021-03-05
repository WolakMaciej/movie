package com.example.movie.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column
@NotNull
    private String name;
@Column
    private String description;

    public Movie(@NotNull String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Movie() {
super();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
