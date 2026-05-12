// service/CollectionService.java
package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.infrastructure.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository repository;

    public CollectionService(CollectionRepository repository) {
        this.repository = repository;
    }

    public List<Card> getOwnedCards(long userId) {
        return repository.findOwnedCardsByUserId(userId);
    }
}