package com.example.spring.crud.simplecrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "films")

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String directorName;
    @Column
    private String filmName;

    public Film(String directorName, String filmName) {
        this.directorName = directorName;
        this.filmName = filmName;
    }

    public Film() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", directorName=" + directorName + ", filmName=" + filmName + "]";
    }

}
