package org.example.thedeckforge.infrastructure;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.interfaces.ICardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CardRepository implements ICardRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void populateCardList() {
    }
    @Override
    public List<Card> returnCardList() {
        return List.of();
    }
    @Override
    public List<Card> returnCardListByName(String name) {

        return List.of();
    }
    @Override
    public Optional<Card> returnCardById(int id) {
        return Optional.empty();
    }
    @Override
    public Optional<Card> returnCardByName(String name) {
        return Optional.empty();
    }
    @Override
    public Optional<Card> returnCardByType(String type) {
        return Optional.empty();
    }
    @Override
    public Optional<Card> returnIllegalStateOfCard() {
        return Optional.empty();
    }
}
