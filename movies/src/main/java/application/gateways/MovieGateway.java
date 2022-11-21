package application.gateways;

import domain.model.Movie;
import java.util.List;
import java.util.UUID;

public interface MovieGateway {

  Movie findById(UUID id);

  List<Movie> findAll();

  UUID save(Movie movie);
}
