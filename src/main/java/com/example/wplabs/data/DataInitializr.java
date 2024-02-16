package com.example.wplabs.data;

import com.example.wplabs.entity.MovieEntity;
import com.example.wplabs.entity.ProductionEntity;
import com.example.wplabs.repository.MovieRepository;
import com.example.wplabs.repository.ProductionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializr {

    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public DataInitializr(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }


    @PostConstruct
    public void initializeData() {
        for (int i = 0; i < 10; i++) {
            MovieEntity movieEntity = new MovieEntity("Title" + i, "Summary" + i, i);
            movieRepository.save(movieEntity);
        }

        for (int i = 0; i < 5; i++) {
            ProductionEntity production = new ProductionEntity("Name" + i, "Country" + i, "Address" + i);
            productionRepository.save(production);
        }
    }
}
