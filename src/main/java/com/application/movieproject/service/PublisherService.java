package com.application.movieproject.service;

import com.application.movieproject.entity.Publisher;
import com.application.movieproject.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherByID(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher with id (" + id + ") not found."));
    }

    public void createPublisher(Publisher publisher) {
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
