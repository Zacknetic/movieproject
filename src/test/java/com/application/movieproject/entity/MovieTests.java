package com.application.movieproject.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MovieTests {

    @Test
    public void testMovieGettersAndSetters() {
        Movie movie = new Movie();
        movie.setTitle("Example Movie");

        assertEquals("Example Movie", movie.getTitle());

    }

}
