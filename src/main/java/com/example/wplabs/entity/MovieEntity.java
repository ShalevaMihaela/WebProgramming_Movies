package com.example.wplabs.entity;

import jakarta.persistence.*;

@Entity
@Table
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String summary;

    private double rating;

    @ManyToOne
    private ProductionEntity production;

    public MovieEntity() {
    }

    public MovieEntity(String title, String summary, double rating) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
    }

    public MovieEntity(String title, String summary, double rating, ProductionEntity production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ProductionEntity getProduction() {
        return production;
    }

    public void setProduction(ProductionEntity production) {
        this.production = production;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
