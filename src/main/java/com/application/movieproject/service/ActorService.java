package com.application.movieproject.service;

import com.application.movieproject.entity.Actor;
import com.application.movieproject.repository.ActorRepository;
import com.application.movieproject.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    public Actor findActorByID(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Actor with id (" + id + ") not found."));
    }

    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }

    public void updateActor(Actor actor) {
        actorRepository.save(actor);
    }

    public String deleteActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Actor with id (" + id + ") not found."));
        actorRepository.delete(actor);

        return "Actor successfully removed with id: (" + actor.getId() + ")";
    }
}
