package com.application.movieproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "meta_data")
public class MetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "duration_minutes", length = 5, nullable = false)
    private int duration_minutes;

    @NonNull
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NonNull
    @Column(name = "language", length = 30)
    private String language;

    @NonNull
    @Column(name = "budget")
    private BigDecimal budget;

    @NonNull
    @Column(name = "box_office_revenue")
    private BigDecimal boxOfficeRevenue;

    @NonNull
    @Column(name = "country_of_origin", length = 50)
    private String countryOfOrigin;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
