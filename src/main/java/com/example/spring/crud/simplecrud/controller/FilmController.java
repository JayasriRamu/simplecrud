package com.example.spring.crud.simplecrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.crud.simplecrud.model.Film;
import com.example.spring.crud.simplecrud.repository.FilmRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmController {
    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/films")
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @GetMapping("/films/{id}")
    public Film getFilm(@PathVariable Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @PostMapping("/films")
    public Film postFilm(@RequestBody Film Film) {
        return filmRepository.save(Film);
    }

    @PutMapping("/films")
    public Film putFilm(@RequestBody Film Film) {
        Film oldFilm = filmRepository.findById(Film.getId()).orElse(null);
        oldFilm.setDirectorName(Film.getDirectorName());
        oldFilm.setFilmName(Film.getFilmName());
        return filmRepository.save(oldFilm);
    }

    @DeleteMapping("/films/{id}")

    public Long deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
        return id;
    }

    // @PostMapping("/")
    // public ResponseEntity<Film> createFilm(@RequestBody Film film) {
    // Film myfilm = filmRepository.save(film);
    // // Film myfilm = filmRepository.save(new Film(film.getDirectorName(),
    // // film.getFilmName()));
    // return new ResponseEntity<Film>(myfilm, HttpStatus.CREATED);
    // }

    // @GetMapping("/")

    // public ResponseEntity<List<Film>> getAllFilms() {
    // List<Film> films = new ArrayList<>();
    // filmRepository.findAll().forEach(films::add);
    // return new ResponseEntity<>(films, HttpStatus.OK);
    // }

    // // build get film by id REST API
    // // http://localhost:8080/api/films/3
    // @GetMapping("/{id}")
    // public ResponseEntity<Film> getEmployeeById(@PathVariable("id") long FilmId)
    // {
    // Optional<Film> FilmData = filmRepository.findById(FilmId);

    // if (FilmData.isPresent()) {
    // return new ResponseEntity<>(FilmData.get(), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<Film> updateFilm(@PathVariable("id") long id,
    // @RequestBody Film film) {
    // Optional<Film> FilmData = filmRepository.findById(id);

    // if (FilmData.isPresent()) {
    // Film _film = FilmData.get();
    // _film.setFilmName(film.getFilmName());
    // _film.setDirectorName(film.getDirectorName());
    // return new ResponseEntity<>(filmRepository.save(_film), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // // return new ResponseEntity<Film>(FilmData.updateFilm(film, id),
    // // HttpStatus.OK);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<HttpStatus> deleteFilm(@PathVariable("id") long id) {
    // try {
    // filmRepository.deleteById(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @DeleteMapping("/")
    // public ResponseEntity<HttpStatus> deleteAllFilms() {
    // try {
    // filmRepository.deleteAll();
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }

    // }

}
