package com.application.movieproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "title", length = 100, nullable = false, unique = true)
    private String title;

    @NonNull
    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movies_actors", joinColumns = {@JoinColumn(name = "movie_id")}, inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movies_genres", joinColumns = {@JoinColumn(name = "movie_id")}, inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movies_publishers", joinColumns = {@JoinColumn(name = "movie_id")}, inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Set<Publisher> publishers = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_links", joinColumns = {@JoinColumn(name = "movie_id")}, inverseJoinColumns = {@JoinColumn(name = "link_id")})
    private Set<Link> links = new HashSet<>();

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaData metaData;

    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
        actor.getMovies().add(this);
    }

    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
        genre.getMovies().add(this);
    }

    public void removeLink(Link link) {
        this.links.remove(link);
    }

    public void addLink(Link link) {
        this.links.add(link);
        link.setMovie(this);
    }

    public void removeMetaData(MetaData metaData) {
        this.metaData = null;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
        metaData.setMovie(this);
    }

    public void removePublisher(Publisher publisher) {
        this.publishers.remove(publisher);
    }

    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.getMovies().add(this);
    }

}
