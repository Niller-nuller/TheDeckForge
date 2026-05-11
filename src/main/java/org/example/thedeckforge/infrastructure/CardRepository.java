package org.example.thedeckforge.infrastructure;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.entity.interfaces.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepository implements ICardRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void populateCardList() {
    }
    @Override
    public List<Card> returnCardList() {
        return List.of();
    }
    @Override
    public List<Card> returnCardListByName(String searchCriteria) {
        String sqlQuery = "SELECT * FROM Cards WHERE CharacterName LIKE ?";
        return jdbcTemplate.query(sqlQuery,(rs, rowNum) ->
                new Card(
                        rs.getLong("CardId"),
                        rs.getString("CharacterName"),
                        CardType.valueOf(rs.getString("CardType").toUpperCase()),
                        rs.getString("Color"),
                        rs.getString("CardSet"),
                        rs.getString("Rarity"),
                        rs.getString("RuleText"),
                        rs.getString("PictureReference"),
                        rs.getString("ManaCost"),
                        rs.getInt("ATK"),
                        rs.getInt("DEF")
                ), searchCriteria
        );
    }
    @Override
    public Optional<Card> returnCardById(long id) {
        String sqlQuery = "SELECT * FROM Cards WHERE CardId = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sqlQuery, (rs, rowNum) ->
                new Card(rs.getLong("CardId"),
                        rs.getString("CharacterName"),
                        CardType.valueOf(rs.getString("CardType").toUpperCase()),
                        rs.getString("Color"),
                        rs.getString("CardSet"),
                        rs.getString("Rarity"),
                        rs.getString("RuleText"),
                        rs.getString("PictureReference"),
                        rs.getString("ManaCost"),
                        rs.getInt("ATK"),
                        rs.getInt("DEF")
                ), id
        ));
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
