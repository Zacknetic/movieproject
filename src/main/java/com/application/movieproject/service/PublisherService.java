package com.application.movieproject.service;

import com.application.movieproject.entity.Publisher;
import com.application.movieproject.repository.GenreRepository;
import com.application.movieproject.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherByID(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher with id (" + id + ") not found."));
    }

    public void addPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public String deletePublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher with id (" + id + ") not found."));
        publisherRepository.delete(publisher);

        return "Publisher successfully removed with id: (" + publisher.getId() + ")";
    }
}
