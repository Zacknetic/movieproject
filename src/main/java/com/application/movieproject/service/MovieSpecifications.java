package com.application.movieproject.service;

import com.application.movieproject.entity.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.function.Function;

public class MovieSpecifications {

    public static Specification<Movie> isWithinRangeInDetails(
            Number min, Number max, Function<Root<Movie>, Path<Number>> columnExtractor) {
        return (root, query, cb) -> {
            Path<Number> columnPath = columnExtractor.apply(root);

            Predicate lowerBound = min != null ? cb.ge(columnPath.as(min.getClass()), min) : cb.conjunction();
            Predicate upperBound = max != null ? cb.le(columnPath.as(max.getClass()), max) : cb.conjunction();

            return cb.and(lowerBound, upperBound);
        };
    }

    // ... other specifications ...
}
