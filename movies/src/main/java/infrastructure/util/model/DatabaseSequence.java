package infrastructure.util.model;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents_sequences")
public record DatabaseSequence(@Id String id, UUID sequence) {
}
