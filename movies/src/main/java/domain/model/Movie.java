package domain.model;

import java.util.UUID;
import lombok.Builder;

@Builder
public record Movie(UUID id, String name) {
}
