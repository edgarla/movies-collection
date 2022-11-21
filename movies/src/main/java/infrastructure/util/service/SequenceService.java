package infrastructure.util.service;

import java.util.UUID;

public interface SequenceService {

  UUID getNextSequenceId(String sequenceName);
}
