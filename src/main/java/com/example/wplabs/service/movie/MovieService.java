package com.example.wplabs.service.movie;

import com.example.wplabs.entity.MovieEntity;

import java.util.List;

public interface MovieService {

    List<MovieEntity> listAll();

    List<MovieEntity> searchMovies(String text, Long value);

    MovieEntity findById(Long id) throws Exception;

    void addMovie(String title, String summary, double rating, Long productionId) throws Exception;

    void deleteMovie(Long id);

    void editMovie(Long id, String title, String summary, double rating, Long productionId) throws Exception;

}
