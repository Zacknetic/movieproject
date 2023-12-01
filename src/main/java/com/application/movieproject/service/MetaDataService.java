package com.application.movieproject.service;

import com.application.movieproject.entity.MetaData;
import com.application.movieproject.repository.MetaDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaDataService {
    private MetaDataRepository metaDataRepository;

    public List<MetaData> findAllMetaData() {
        return metaDataRepository.findAll();
    }

    public MetaData findMetaDataByID(Long id) {
        return metaDataRepository.findById(id).orElseThrow(() -> new RuntimeException("MetaData with id (" + id + ") not found."));
    }

    public void createMetaData(MetaData metaData) {
        metaDataRepository.save(metaData);
    }

    public void updateMetaData(MetaData metaData) {
        metaDataRepository.save(metaData);
    }

    public String deleteMetaDataById(Long id) {
        MetaData metaData = metaDataRepository.findById(id).orElseThrow(() -> new RuntimeException("MetaData with id (" + id + ") not found."));
        metaDataRepository.delete(metaData);

        return "MetaData successfully removed with id: (" + metaData.getId() + ")";
    }
}
