// infrastructure/CollectionRepository.java
package org.example.thedeckforge.infrastructure;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.entity.interfaces.ICollectionRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CollectionRepository implements ICollectionRepository {

    private final JdbcTemplate jdbc;

    public CollectionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Card> findOwnedCardsByUserId(long userId) {
        String sql = """
            SELECT
                c.CardId, c.CharacterName, c.CardType, c.Color, c.CardSet,
                c.Rarity, c.RuleText, c.PictureReference, c.ManaCost,
                c.ATK, c.DEF
            FROM Cards c
            JOIN Collections col ON c.CardId = col.CardId
            WHERE col.UserId = ?
            ORDER BY c.Rarity, c.CharacterName
            """;

        return jdbc.query(sql, (rs, rowNum) -> new Card(
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
        ), userId);
    }
}