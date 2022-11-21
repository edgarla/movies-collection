package infrastructure.repository;

import infrastructure.entities.Movie;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoMoviesRepository extends MongoRepository<Movie, UUID> {
}
