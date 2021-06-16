package ge.btu.service.impl;

import ge.btu.dto.movie.AddMovieInput;
import ge.btu.dto.movie.MovieDTO;
import ge.btu.model.Movie;
import ge.btu.repository.MovieRepository;
import ge.btu.service.MovieService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @SneakyThrows
    @Override
    public MovieDTO addMovie(AddMovieInput movie) {
        Movie newMovie = Movie.builder()
                .title(movie.getTitle())
                .country(movie.getCountry())
                .build();

        return new MovieDTO(movieRepository.save(newMovie));
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO getMovie(Long id) {
        Movie movie = movieRepository.getById(id);

        return new MovieDTO(movie);
    }


    @Override
    public List<MovieDTO> getMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream().map(MovieDTO::new).collect(Collectors.toList());
    }

}
