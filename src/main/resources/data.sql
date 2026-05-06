
-- =============================================================
--  DeckForgeDB — Sample Inserts
-- =============================================================

-- -------------------------------------------------------------
-- Card_Register
-- -------------------------------------------------------------
INSERT INTO Card_Register (CharacterName, CardType, Color, CardSet, Rarity, RuleText, PictureReference, ManaCost, ATK, DEF) VALUES
                                                                                                                                ('Storm Dragon',      'Creature',  'Blue',  'Elemental Surge',   'Rare',       'Flying. When Storm Dragon enters the battlefield, draw a card.',                            'img/storm_dragon.png',      '{3}{U}{U}', 5, 4),
                                                                                                                                ('Iron Golem',        'Creature',  'Gray',  'Forge of Ages',     'Uncommon',   'Trample. Iron Golem gets +2/+2 as long as you control an artifact.',                        'img/iron_golem.png',        '{5}',       6, 6),
                                                                                                                                ('Ember Witch',       'Creature',  'Red',   'Elemental Surge',   'Common',     'Haste. When Ember Witch attacks, deal 1 damage to any target.',                             'img/ember_witch.png',       '{2}{R}',    2, 1),
                                                                                                                                ('Ancient Oak',       'Creature',  'Green', 'Wilds Awakened',    'Common',     'Reach. At the beginning of your upkeep, gain 1 life.',                                      'img/ancient_oak.png',       '{1}{G}',    1, 4),
                                                                                                                                ('Shadow Assassin',   'Creature',  'Black', 'Veil of Darkness',  'Rare',       'Deathtouch, Hexproof. Shadow Assassin can only be blocked by creatures with flying.',       'img/shadow_assassin.png',   '{2}{B}{B}', 3, 2),
                                                                                                                                ('Holy Paladin',      'Creature',  'White', 'Sacred Order',      'Uncommon',   'Vigilance. Other creatures you control get +1/+1.',                                         'img/holy_paladin.png',      '{2}{W}{W}', 2, 4),
                                                                                                                                ('Arcane Bolt',       'Instant',   'Blue',  'Elemental Surge',   'Common',     'Counter target spell unless its controller pays {2}.',                                      'img/arcane_bolt.png',       '{1}{U}',    NULL, 0),
                                                                                                                                ('Inferno Wave',      'Sorcery',   'Red',   'Forge of Ages',     'Rare',       'Inferno Wave deals 4 damage to each creature your opponents control.',                      'img/inferno_wave.png',      '{4}{R}{R}', NULL, 0),
                                                                                                                                ('Nature''s Bounty',  'Enchantment','Green','Wilds Awakened',    'Uncommon',   'At the beginning of your draw step, you may draw an additional card. If you do, discard a card.', 'img/natures_bounty.png', '{2}{G}', NULL, 0),
                                                                                                                                ('Cursed Relic',      'Artifact',  'Gray',  'Veil of Darkness',  'Legendary',  'Tap: Add {B} to your mana pool. Creatures you control gain Deathtouch until end of turn.',  'img/cursed_relic.png',      '{3}',       NULL, 0);

-- -------------------------------------------------------------
-- Credentials  (passwords are bcrypt hashes of 'Password123!')
-- -------------------------------------------------------------
INSERT INTO Credentials (Email, PasswordHash, UserRole) VALUES
                                                            ('admin@deckforge.com',   '$2a$12$KIXnHs3PBFMTabcXyz1234abcXYZ5678abcXYZ9012abcXYZ3456ab', 'ADMIN'),
                                                            ('alice@example.com',     '$2a$12$ABCdef1234abcXYZ5678abcXYZ9012abcXYZ3456abcXYZ7890ab', 'MEMBER'),
                                                            ('bob@example.com',       '$2a$12$XYZabc5678abcXYZ9012abcXYZ3456abcXYZ7890abcXYZ1234ab', 'MEMBER'),
                                                            ('carol@example.com',     '$2a$12$LMNopq9012abcXYZ3456abcXYZ7890abcXYZ1234abcXYZ5678ab', 'MEMBER'),
                                                            ('dave@example.com',      '$2a$12$QRStuv3456abcXYZ7890abcXYZ1234abcXYZ5678abcXYZ9012ab', 'MODERATOR');

-- -------------------------------------------------------------
-- Users
-- -------------------------------------------------------------
INSERT INTO Users (Name, Age, UserCredentialsId) VALUES
                                                     ('Admin Account', 30, 1),
                                                     ('Alice Johnson',  25, 2),
                                                     ('Bob Smith',      32, 3),
                                                     ('Carol White',    28, 4),
                                                     ('Dave Brown',     35, 5);

-- -------------------------------------------------------------
-- User_Collection
-- -------------------------------------------------------------
INSERT INTO User_Collection (UserCollectionId, UserId, CollectionVisibility) VALUES
                                                                                         (1, 2,  'PUBLIC'),   -- Alice's collection
                                                                                         (2, 2,  'PUBLIC'),
                                                                                         (3, 3,  'PRIVATE'),  -- Bob's collection
                                                                                         (4, 3,  'PRIVATE'),
                                                                                         (5, 4,  'PUBLIC'),   -- Carol's collection
                                                                                         (6, 4,  'PUBLIC'),
                                                                                         (7, 4,  'FRIENDS'),
                                                                                         (8, 5,  'PUBLIC');   -- Dave's collection

-- -------------------------------------------------------------
-- User_Collection_Cards
-- -------------------------------------------------------------
INSERT INTO User_Collection_Cards (UserCollectionId, CardId, Quantity, CollectionCardStatus) VALUES
                                                                                                 (1, 1, 2, 'OWNED'),
                                                                                                 (2, 3, 4, 'OWNED'),
                                                                                                 (3, 2, 1, 'OWNED'),
                                                                                                 (4, 8, 3, 'WISHLIST'),
                                                                                                 (5, 5, 2, 'OWNED'),
                                                                                                 (6, 6, 1, 'OWNED'),
                                                                                                 (7, 9, 1, 'WISHLIST'),
                                                                                                 (8, 4, 2, 'OWNED');