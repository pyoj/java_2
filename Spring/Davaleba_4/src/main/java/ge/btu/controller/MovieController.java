package ge.btu.controller;


import ge.btu.dto.movie.AddMovieInput;
import ge.btu.dto.movie.MovieDTO;
import ge.btu.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movie/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("movies")
    public List<MovieDTO> getAllMovies() {
        return movieService.getMovies();
    }

    @PostMapping("addMovie")
    public MovieDTO addMovie(@RequestBody @Validated AddMovieInput addMovieInput) {
        return movieService.addMovie(addMovieInput);
    }

    @DeleteMapping("deleteMovie/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @PostMapping("fileUpload")
    public void addMovie(@RequestParam("file") MultipartFile file) {
    }
}
