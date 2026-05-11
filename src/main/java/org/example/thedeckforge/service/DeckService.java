package org.example.thedeckforge.service;
import org.example.thedeckforge.entity.Deck;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.interfaces.IDeckRepository;
import org.example.thedeckforge.infrastructure.DeckRepository;
import org.example.thedeckforge.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class DeckService {
private final DeckRepository deckRepository;
private final UserRepository userRepository;
@Autowired
public DeckService(DeckRepository deckRepository, UserRepository userRepository) {
    this.deckRepository = deckRepository;
    this.userRepository = userRepository;
}

private User getCurrentUser(){
    String email = SecurityContextHolder.getContext()
            .getAuthentication()
            .getName();

    return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not Found for email: " + email));
}

public void createDeck(Deck deck){
    User user = getCurrentUser();
    deck.setCards(new ArrayList<>());
    user.addDeck(deck);
    long Userid = userRepository.getUserId(user);
    deckRepository.createUserDeck(deck,Userid);
}

    public Deck getDeckForm(){
        return new Deck();
    }
}
