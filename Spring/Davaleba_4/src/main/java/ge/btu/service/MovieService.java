package ge.btu.service;

import ge.btu.dto.movie.AddMovieInput;
import ge.btu.dto.movie.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(AddMovieInput movie);

    void deleteMovie(Long id);

    MovieDTO getMovie(Long id);

    List<MovieDTO> getMovies();

}
