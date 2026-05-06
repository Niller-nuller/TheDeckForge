DROP TABLE IF EXISTS DeckForgeDB;

CREATE TABLE Card_Register (
    CardId BIGINT AUTO_INCREMENT PRIMARY KEY,
    CharacterName VARCHAR(100),
    CardType VARCHAR(50),
    Color VARCHAR(50),
    CardSet VARCHAR(100),
    Rarity VARCHAR(50),
    RuleText VARCHAR(1800),
    PictureReference VARCHAR(500),
    ManaCost VARCHAR(20),
    ATK INT,
    DEF INT NOT NULL
);

CREATE TABLE Credentials (
    CredentialsId BIGINT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(100) NOT NULL UNIQUE,
    PasswordHash VARCHAR(255) NOT NULL,
    UserRole VARCHAR(50) NOT NULL DEFAULT MEMBER
);

CREATE TABLE Users (
    UserId BIGINT AUTO_INCREMENT PRIMARY KEY,
    UserCredentialsId BIGINT NOT NULL,
    Name VARCHAR(100),
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (UserCredentialsId) REFERENCES Credentials(CredentialsId)
);

CREATE TABLE User_Collection (
    UserCollectionId BIGINT PRIMARY KEY,
    CollectionVisibility VARCHAR(20) NOT NULL,
    FOREIGN KEY (UserCollectionId) REFERENCES Users(UserId) --Enforced 1:1 relationship with User
);

CREATE TABLE User_Collection_Cards (
    UserCollectionId BIGINT NOT NULL PRIMARY KEY,
    CardId BIGINT NOT NULL,
    Quantity INT NOT NULL DEFAULT 1,
    CollectionCardStatus VARCHAR(20) NOT NULL,
    FOREIGN KEY (UserCollectionId) REFERENCES User_Collection(UserCollectionId),
    FOREIGN KEY (CardId) REFERENCES Card_Register(CardId)
);




