package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.infrastructure.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Card> getOwnedCards(long userId) {
        return collectionRepository.findOwnedCardsByUserId(userId);
    }

    public List<Card> getOwnedCards(long userId, int page, int pageSize) {
        return collectionRepository.findOwnedCardsByUserId(userId, page, pageSize);
    }

    public int countOwnedCards(long userId) {
        return collectionRepository.countOwnedCardsByUserId(userId);
    }
}
