package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.interfaces.IUserRepository;
import org.example.thedeckforge.validation.ValidationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final IUserRepository userRepository;

    @Autowired
    public RegisterService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Authority register(User user) {
        String hashed = BCrypt.hashpw(user.getAuthority().getPassword(), BCrypt.gensalt());
        user.getAuthority().setPassword(hashed);
        userRepository.createUserAuthority(user.getAuthority());
        userRepository.createUser(user);
        return user.getAuthority();
    }
    public User getUserForm(){
        return new User();
    }

}