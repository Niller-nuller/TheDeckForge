INSERT INTO Card_Register (CharacterName, CardType, Color, CardSet, Rarity, RuleText, PictureReference, ManaCost, ATK, DEF) VALUES
-- ============ WHITE — Sacred Order ============
('Squire of the Crown',
 'Creature', 'White', 'Sacred Order', 'Common',
 'Vigilance',
 'img/squire_of_the_crown.png', '{W}', 1, 2),

('Radiant Mender',
 'Creature', 'White', 'Sacred Order', 'Uncommon',
 'Lifelink. When Radiant Mender enters the battlefield, you gain 3 life.',
 'img/radiant_mender.png', '{2}{W}', 2, 3),

('Wing of Reckoning',
 'Instant', 'White', 'Sacred Order', 'Common',
 'Destroy target attacking or blocking creature.',
 'img/wing_of_reckoning.png', '{1}{W}', NULL, 0),

-- ============ BLUE — Elemental Surge ============
('Tidescale Scout',
 'Creature', 'Blue', 'Elemental Surge', 'Common',
 'Flying',
 'img/tidescale_scout.png', '{U}', 1, 1),

('Manawell Sage',
 'Creature', 'Blue', 'Elemental Surge', 'Uncommon',
 '{T}: Draw a card. Skip your next draw step.',
 'img/manawell_sage.png', '{2}{U}', 1, 3),

('Glimpse the Past',
 'Sorcery', 'Blue', 'Elemental Surge', 'Common',
 'Target opponent reveals their hand. Draw a card.',
 'img/glimpse_the_past.png', '{2}{U}', NULL, 0),

-- ============ BLACK — Veil of Darkness ============
('Crypt Stalker',
 'Creature', 'Black', 'Veil of Darkness', 'Common',
 'Menace (This creature can''t be blocked except by two or more creatures.)',
 'img/crypt_stalker.png', '{1}{B}', 2, 2),

('Soulrend Vampire',
 'Creature', 'Black', 'Veil of Darkness', 'Uncommon',
 'Lifelink, Deathtouch',
 'img/soulrend_vampire.png', '{2}{B}', 3, 2),

('Pact of Decay',
 'Sorcery', 'Black', 'Veil of Darkness', 'Common',
 'Target opponent loses 3 life. You lose 1 life and draw a card.',
 'img/pact_of_decay.png', '{2}{B}', NULL, 0),

-- ============ RED — Forge of Ages ============
('Lavaforge Goblin',
 'Creature', 'Red', 'Forge of Ages', 'Common',
 'Haste',
 'img/lavaforge_goblin.png', '{R}', 2, 1),

('Crackling Pyromancer',
 'Creature', 'Red', 'Forge of Ages', 'Uncommon',
 'Whenever you cast an instant or sorcery spell, Crackling Pyromancer deals 1 damage to any target.',
 'img/crackling_pyromancer.png', '{2}{R}', 2, 2),

-- ============ GREEN — Wilds Awakened ============
('Thornback Boar',
 'Creature', 'Green', 'Wilds Awakened', 'Common',
 'Trample',
 'img/thornback_boar.png', '{2}{G}', 3, 3),

('Mossback Behemoth',
 'Creature', 'Green', 'Wilds Awakened', 'Rare',
 'Trample, Hexproof (This creature can''t be the target of spells or abilities your opponents control.)',
 'img/mossback_behemoth.png', '{3}{G}{G}', 5, 5),

-- ============ LAND — colorless ============
('Crystal Caverns',
 'Land', 'Gray', 'Forge of Ages', 'Common',
 '{T}: Add one mana of any color. Crystal Caverns enters the battlefield tapped.',
 'img/crystal_caverns.png', '', NULL, 0);