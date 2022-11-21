package infrastructure.entities;

import java.util.UUID;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "movies")
public record Movie(@Id UUID id, String name) {

  @Transient
  public static final String SEQUENCE_NAME = "movies_sequence";
}
