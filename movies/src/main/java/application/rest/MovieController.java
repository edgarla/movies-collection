package application.rest;

import application.rest.requests.AddMovieRequest;
import domain.model.Movie;
import domain.services.MovieService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping(value = "/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> getMovieById(@PathVariable final UUID id) {
    return ResponseEntity.ok(movieService.findById(id));
  }

  @GetMapping(value = "/all", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Movie>> getAllMovies() {
    return ResponseEntity.ok(movieService.findAll());
  }

  @PostMapping(value = "/add", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  public ResponseEntity<UUID> addBook(@RequestBody final AddMovieRequest request) {
    return ResponseEntity.ok(movieService.save(Movie.builder().name(request.name()).build()));
  }
}
