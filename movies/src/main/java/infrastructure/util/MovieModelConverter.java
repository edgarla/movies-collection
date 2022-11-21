package infrastructure.util;

import infrastructure.entities.Movie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MovieModelConverter implements Converter<Movie, domain.model.Movie> {

  @NonNull
  @Override
  public domain.model.Movie convert(Movie source) {
    return domain.model.Movie.builder()
            .id(source.id())
            .name(source.name())
            .build();
  }
}
