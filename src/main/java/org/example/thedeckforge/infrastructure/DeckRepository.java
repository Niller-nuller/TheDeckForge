package org.example.thedeckforge.infrastructure;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.Deck;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.enums.FormatType;
import org.example.thedeckforge.entity.interfaces.IDeckRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DeckRepository implements IDeckRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUserDeck(Deck deck, long Userid){
        String sql = "INSERT INTO Decks (UserId, DeckName, DeckFormat) VALUES (?, ?, ?) ";
        jdbcTemplate.update(sql,Userid,deck.getName(),deck.getFormat());
    }


    @Override
    public List<Deck> getUsersDecks (User user){
        String deckIdSql = "SELECT DeckID FROM Users RIGHT JOIN Decks ON Users.UserId = Decks.UserId where email = ?";
        ArrayList<Integer> deckIds = new ArrayList<>();
        jdbcTemplate.queryForList(deckIdSql,user.getAuthority().getEmail(),deckIds);
        String deckInfoSql = "SELECT * FROM Decks WHERE DeckID = ?";
        String deckContentsSql = "SELECT * FROM Cards LEFT JOIN DeckkCards ON Cards.CardId = DeckkCards.CardId WHERE DeckId = ?";
        List<Deck> decks = new ArrayList<>();
        for (Integer deckId : deckIds) {
            Deck deck = jdbcTemplate.queryForObject(deckInfoSql,(rs, rowNum) -> new Deck(rs.getString("DeckName"), FormatType.valueOf(rs.getString("DeckFormat"))), deckId);
            ArrayList<Card> cards = new ArrayList<>();
            jdbcTemplate.queryForList(deckContentsSql,deckId,cards);
            deck.setCards(cards);
            decks.add(deck);
        }
        return decks;
    }

}
