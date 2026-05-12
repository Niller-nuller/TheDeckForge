package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICollectionRepository {
    List<Card> findOwnedCardsByUserId(long userId);
}
