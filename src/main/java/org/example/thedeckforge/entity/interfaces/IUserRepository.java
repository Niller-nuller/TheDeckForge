package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepository {
    Authority logUserIn(Authority userAuth);
    void createUserAuthority(Authority userAuth);
    void createUser(User user);
    User getUserFromAuth(Authority userAuth);
    Long getUserLoginId(Authority userAuth);
    User findByEmail(String email);
    Long getUserId(User user);
}
