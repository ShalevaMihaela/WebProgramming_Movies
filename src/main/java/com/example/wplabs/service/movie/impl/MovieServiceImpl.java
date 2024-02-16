package com.example.wplabs.service.movie.impl;

import com.example.wplabs.entity.MovieEntity;
import com.example.wplabs.entity.ProductionEntity;
import com.example.wplabs.repository.MovieRepository;
import com.example.wplabs.repository.ProductionRepository;
import com.example.wplabs.service.movie.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<MovieEntity> listAll() {
        return movieRepository.findAll();
    }


    @Override
    public List<MovieEntity> searchMovies(String text, Long value) {
        if (text != null && value == null) {
            return movieRepository.findAllByTitleContaining(text);
        } else if (text == null && value != null) {
            return movieRepository.findAllByRatingGreaterThanEqual(value);
        } else if (text != null) {
            return movieRepository.findAllByTitleContainingAndRatingGreaterThanEqual(text, value);
        } else {
            return movieRepository.findAll();
        }

    }

    @Override
    public MovieEntity findById(Long id) throws Exception {
        return movieRepository.findById(id).orElseThrow(Exception::new);
    }


    @Override
    public void addMovie(String title, String summary, double rating, Long productionId) throws Exception {
        ProductionEntity production = productionRepository.findById(productionId).orElseThrow(Exception::new);
        movieRepository.save(new MovieEntity(title, summary, rating, production));
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


    @Override
    public void editMovie(Long id, String title, String summary, double rating, Long productionId) throws Exception {
        ProductionEntity production = productionRepository.findById(productionId).orElseThrow(Exception::new);
        MovieEntity movie = movieRepository.findById(id).orElseThrow(Exception::new);

        movie.setTitle(title);
        movie.setSummary(summary);
        movie.setRating(rating);
        movie.setProduction(production);

        movieRepository.save(movie);
    }

}
