package infrastructure.util;

import domain.model.Movie;
import infrastructure.util.service.SequenceService;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieEntityConverter implements Converter<Movie, infrastructure.entities.Movie> {

  private final SequenceService sequenceService;

  @NonNull
  @Override
  public infrastructure.entities.Movie convert(Movie source) {
    return infrastructure.entities.Movie.builder()
            .id(Objects.isNull(source.id()) ? sequenceService.getNextSequenceId(infrastructure.entities.Movie.SEQUENCE_NAME) : source.id())
            .build();
  }
}
