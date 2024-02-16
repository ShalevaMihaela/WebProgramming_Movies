package com.example.wplabs.controller;

import com.example.wplabs.service.movie.MovieService;
import com.example.wplabs.service.production.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final ProductionService productionService;

    public MovieController(MovieService movieService, ProductionService productionService) {
        this.movieService = movieService;
        this.productionService = productionService;
    }


    @GetMapping("/movies")
        public String getMoviesPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }


    @GetMapping("/filter")
    public String getMoviesPageFilter(@RequestParam(name = "movieTitle", required = false) String movieTitle,
                                      @RequestParam(name = "rating", required = false) Long rating, Model model) {
        model.addAttribute("movies", movieService.searchMovies(movieTitle, rating));
        return "listMovies";
    }



    @GetMapping("/movies/add")
    public String getAddMoviePage(Model model) {
        model.addAttribute("productions", productionService.findAll());
        return "add-movie";
    }


    @GetMapping("/movies/edit/{id}")
    public String getEditMoviePage(@PathVariable(name = "id") Long id, Model model) throws Exception {
        model.addAttribute("productions", productionService.findAll());
        model.addAttribute("movie", movieService.findById(id));
        return "add-movie";
    }


    @PostMapping("/movies/add")
    public String addMovie(@RequestParam(name = "title") String title, @RequestParam(name = "summary") String summary,
                           @RequestParam(name = "rating") double rating, @RequestParam(name = "productionId") Long productionId) throws Exception {
        movieService.addMovie(title, summary, rating, productionId);
        return "redirect:/movies";
    }


    @PostMapping("/movies/edit/{id}")
    public String editMovie(@PathVariable(name = "id") Long id,
                            @RequestParam(name = "title") String title, @RequestParam(name = "summary") String summary,
                            @RequestParam(name = "rating") double rating, @RequestParam(name = "productionId") Long productionId) throws Exception {
        movieService.editMovie(id, title, summary, rating, productionId);
        return "redirect:/movies";
    }


    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable(name = "id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
