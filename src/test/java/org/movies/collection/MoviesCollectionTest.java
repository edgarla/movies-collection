package org.movies.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoviesCollectionTest {

  @Test
  void contextLoad() {
    MoviesCollectionApplication application = new MoviesCollectionApplication();
    Assertions.assertNotNull(application);
  }
}
