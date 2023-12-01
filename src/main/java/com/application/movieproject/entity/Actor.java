package com.application.movieproject.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @NonNull
    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.MERGE)
    private Set<Movie> movies = new HashSet<>();
}
