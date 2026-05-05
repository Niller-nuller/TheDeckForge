package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;

public interface IUserRepository {
    Authority logUserIn(Authority userAuth);
    void createUserAuthority(Authority userAuth);
    void createUser(User user);
    User getUserFromAuth(Authority userAuth);
    Long getUserLoginId(Authority userAuth);
}
