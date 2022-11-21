package infrastructure.gateways;

import application.gateways.MovieGateway;
import domain.model.Movie;
import infrastructure.repository.SpringDataMongoMoviesRepository;
import infrastructure.util.MovieEntityConverter;
import infrastructure.util.MovieModelConverter;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class MovieGatewayImpl implements MovieGateway {

  private final SpringDataMongoMoviesRepository repository;
  private final MovieModelConverter movieModelConverter;
  private final MovieEntityConverter movieEntityConverter;

  public MovieGatewayImpl(SpringDataMongoMoviesRepository repository,
                          MovieModelConverter movieModelConverter,
                          MovieEntityConverter movieEntityConverter) {
    this.repository = repository;
    this.movieModelConverter = movieModelConverter;
    this.movieEntityConverter = movieEntityConverter;
  }

  @Override
  public Movie findById(UUID id) {
    return movieModelConverter.convert(repository.findById(id).orElseThrow());
  }

  @Override
  public List<Movie> findAll() {
    return repository.findAll().stream()
            .map(movieModelConverter::convert)
            .toList();
  }

  @Override
  public UUID save(Movie movie) {
    return repository.save(movieEntityConverter.convert(movie)).id();
  }
}
