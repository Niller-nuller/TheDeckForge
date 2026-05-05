package org.example.thedeckforge.entity;

import org.example.thedeckforge.entity.enums.Roles;

import java.util.List;

public class Authority {
    private String email;
    private String password;
    private Roles roles;
    public Authority(String email, String password, Roles roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public Authority() {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getRoles() {
        return roles;
    }
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
