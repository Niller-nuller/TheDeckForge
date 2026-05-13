package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {
    Authority logUserIn(Authority userAuth);
    void createUserAuthority(Authority userAuth);
    void createUser(User user);
    User getUserFromAuth(Authority userAuth);
    Long getUserLoginId(Authority userAuth);
    Authority findAuthiortyByEmail(String email);
    User findUserByEmail(String email);
    UserDetails findUserDetailsByEmail(String email);
    Long getUserId(User user);
}
