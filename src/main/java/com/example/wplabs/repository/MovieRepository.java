package com.example.wplabs.repository;

import com.example.wplabs.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {


    List<MovieEntity> findAllByTitleContaining(String text);

    List<MovieEntity> findAllByRatingGreaterThanEqual(Long value);

    List<MovieEntity> findAllByTitleContainingAndRatingGreaterThanEqual(String text, Long value);
}
