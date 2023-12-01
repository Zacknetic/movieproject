package com.application.movieproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", length = 100, nullable = false, unique = true)
    private String url;
}
