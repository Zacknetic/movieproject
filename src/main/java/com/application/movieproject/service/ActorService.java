package com.application.movieproject.service;

import com.application.movieproject.entity.Actor;
import com.application.movieproject.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private ActorRepository actorRepository;

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    public Actor findActorByID(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Actor with id (" + id + ") not found."));
    }

    public void createActor(Actor actor) {
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
