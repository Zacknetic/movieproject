package com.application.movieproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false, unique = true)
    private String title;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @Column(name = "duration_minutes", length = 5, nullable = false)
    private int duration_minutes;
}
