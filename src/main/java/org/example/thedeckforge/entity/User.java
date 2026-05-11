package org.example.thedeckforge.entity;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String name;
    private LocalDate age;
    private Authority authority;
    private Collection collection;
    private List<Deck> decks;
    public User(String name, LocalDate age, Authority authority, Collection collection, List<Deck> decks) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("User's name cannot be empty");
        }
        this.name = name;
        this.age = age;
        this.authority = authority;
        this.collection = collection;
        this.decks = decks;
    }
    public User(String name, LocalDate age, Authority authority) {
        this.name = name;
        this.age = age;
        this.authority = authority;
    }
    public User(){}

    public Authority getAuthority() {
        return authority;
    }
    public LocalDate getAge() {
        return age;
    }
    public void setAge(LocalDate age) {
        this.age = age;
    }
    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
