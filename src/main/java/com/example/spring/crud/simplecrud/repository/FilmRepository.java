package com.example.spring.crud.simplecrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.crud.simplecrud.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    // List<Film> getAllFilms();
    // List<Film> findByFilmName(String filmName);
}
