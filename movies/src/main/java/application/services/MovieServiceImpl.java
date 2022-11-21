package application.services;

import application.gateways.MovieGateway;
import domain.model.Movie;
import domain.services.MovieService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  private final MovieGateway movieGateway;

  public MovieServiceImpl(MovieGateway movieGateway) {
    this.movieGateway = movieGateway;
  }

  @Override
  public Movie findById(UUID id) {
    return movieGateway.findById(id);
  }

  @Override
  public List<Movie> findAll() {
    return movieGateway.findAll();
  }

  @Override
  public UUID save(Movie movie) {
    return movieGateway.save(movie);
  }
}
