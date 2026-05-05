package org.example.thedeckforge.entity;

import org.example.thedeckforge.entity.enums.Roles;

import java.util.List;

public class User {
    private String name;
    private int age;
    private Authority authority;
    private Collection collection;
    private List<Deck> decks;
    public User(String name, int age, Authority authority, Collection collection, List<Deck> decks) {
        this.name = name;
        this.age = age;
        this.authority = authority;
        this.collection = collection;
        this.decks = decks;
    }
    public User(String name, int age, Authority authority) {
        this.name = name;
        this.age = age;
        this.authority = authority;
    }
    public User(){}

    public Authority getAuthority() {
        return authority;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
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
