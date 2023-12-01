package com.application.movieproject.repository;

import com.application.movieproject.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaDataRepository extends JpaRepository<MetaData, Long> {
}
