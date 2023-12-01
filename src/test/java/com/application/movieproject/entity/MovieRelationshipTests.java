package com.application.movieproject.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.application.movieproject.repository.MovieRepository;
import com.application.movieproject.service.MovieService;
import com.application.movieproject.service.MovieSpecifications;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class MovieRelationshipTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;

    private Movie testMovie;
    private MetaData testMetaData;

    @BeforeEach
    public void setUp() {
        testMovie = new Movie();
        testMovie.setTitle("Test Movie");
        testMovie.setDescription("This is a test movie.");

        testMetaData = new MetaData();
        testMetaData.setDuration_minutes(120);
        testMetaData.setReleaseDate(LocalDate.of(2023,12, 6));
        testMetaData.setLanguage("Japanese");
        testMetaData.setBudget(BigDecimal.valueOf(500000));
        testMetaData.setBoxOfficeRevenue(BigDecimal.valueOf(2000000));
        testMetaData.setCountryOfOrigin("Japan");

        testMovie.setMetaData(testMetaData);
        testMetaData.setMovie(testMovie);
    }

    @Test
    public void testMovieRelationship() {
        Movie savedMovie = movieRepository.save(testMovie);

        assertNotNull(savedMovie.getId());
        assertEquals("Test Movie", savedMovie.getTitle());
        assertEquals("This is a test movie.", savedMovie.getDescription());
    }

    @Test
    public void testMovieAndMetaDataRelationship() {
        Movie savedMovie = movieRepository.save(testMovie);
        MetaData savedMetaData = savedMovie.getMetaData();

        // Verify that data is stored correctly
        assertNotNull(savedMetaData);
        assertEquals(120, savedMetaData.getDuration_minutes());
        assertEquals(LocalDate.of(2023,12, 6), savedMetaData.getReleaseDate());
        assertEquals("Japanese", savedMetaData.getLanguage());
        assertEquals(BigDecimal.valueOf(500000), savedMetaData.getBudget());
        assertEquals(BigDecimal.valueOf(2000000), savedMetaData.getBoxOfficeRevenue());
        assertEquals("Japan", savedMetaData.getCountryOfOrigin());

        // Verify that the relationship is bidirectional
        assertEquals(savedMovie.getId(), savedMetaData.getMovie().getId());
    }

    @Test
    public void testMetaDataIsPersistedWithMovie() {
        Movie savedMovie = movieRepository.save(testMovie);

        assertNotNull(entityManager.find(MetaData.class, savedMovie.getMetaData().getId()));
    }

    @Test
    public void testMovieDeletionAlsoRemovesMetaData() {
        Movie savedMovie = movieRepository.save(testMovie);
        Long metaDataId = savedMovie.getMetaData().getId();

        movieRepository.delete(savedMovie);

        assertNull(entityManager.find(Movie.class, savedMovie.getId()));
        assertNull(entityManager.find(MetaData.class, metaDataId));
    }

    @Test
    public void testFindMoviesByDurationRangeUsingSpecification() {
        // Save test data
        movieRepository.save(testMovie);

        // Additional movies to cover different duration scenarios
        // ...

        // Create specification for duration range
        Specification<Movie> durationSpec = MovieSpecifications.isWithinRangeInDetails(
                90, // min duration
                120, // max duration
                root -> root.join("metaData").get("duration_minutes")
        );

        // Use the specification to find movies
        List<Movie> movies = movieRepository.findAll(durationSpec);

        // Assertions
        assertFalse(movies.isEmpty(), "No movies found within the specified duration range");
        for (Movie movie : movies) {
            int duration = movie.getMetaData().getDuration_minutes();
            assertTrue(duration >= 90 && duration <= 120, "Movie duration is outside the specified range");
        }
    }



    // Add more tests to cover other aspects as needed...
}
