package domain.services;

import domain.model.Movie;
import java.util.List;
import java.util.UUID;

public interface MovieService {

  Movie findById(UUID id);

  List<Movie> findAll();

  UUID save(Movie movie);
}
