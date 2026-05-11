package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IUserRepository {
    Authority logUserIn(Authority userAuth);
    void createUserAuthority(Authority userAuth);
    void createUser(User user);
    User getUserFromAuth(Authority userAuth);
    Long getUserLoginId(Authority userAuth);
    Long getUserId(User user);
}
