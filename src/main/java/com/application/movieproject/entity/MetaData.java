package com.application.movieproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meta_data")
public class MetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duration_minutes", length = 5, nullable = false)
    private int duration_minutes;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "language", length = 30)
    private String language;

    @Column(name = "budget")
    private BigDecimal budget;

    @Column(name = "box_office_revenue")
    private BigDecimal boxOfficeRevenue;

    @Column(name = "country_of_origin", length = 50)
    private String countryOfOrigin;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
