package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Deck;
import org.example.thedeckforge.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeckRepository {

    List<Deck> getUsersDecks(User user);
    void createUserDeck(Deck deck, User user);


}
