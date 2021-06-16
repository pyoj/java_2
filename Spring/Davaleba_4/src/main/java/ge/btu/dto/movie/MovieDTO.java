package ge.btu.dto.movie;

import ge.btu.model.Movie;
import lombok.Data;

@Data
public class MovieDTO {


    public MovieDTO(Movie movie) {
        id = movie.getId();
        this.title = movie.getTitle();
        this.country = movie.getCountry();
    }

    Long id;

    String title;

    String country;

}
