package com.application.movieproject.service;

import com.application.movieproject.entity.Link;
import com.application.movieproject.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    public List<Link> findAllLinks() {
        return linkRepository.findAll();
    }

    public Link findLinkByID(Long id) {
        return linkRepository.findById(id).orElseThrow(() -> new RuntimeException("Link with id (" + id + ") not found."));
    }

    public void createLink(Link link) {
        linkRepository.save(link);
    }

    public void updateLink(Link link) {
        linkRepository.save(link);
    }

    public String deleteLinkById(Long id) {
        Link link = linkRepository.findById(id).orElseThrow(() -> new RuntimeException("Link with id (" + id + ") not found."));
        linkRepository.delete(link);

        return "Link successfully removed with id: (" + link.getId() + ")";
    }
}
