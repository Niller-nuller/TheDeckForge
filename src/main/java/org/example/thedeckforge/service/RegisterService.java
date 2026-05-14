package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.interfaces.IUserRepository;
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
    public void register(User user) {
        String hashed = BCrypt.hashpw(user.getAuthority().getPassword(), BCrypt.gensalt());
        user.getAuthority().setPassword(hashed);
        userRepository.createUserAuthority(user.getAuthority());
        userRepository.createUser(user);
    }
    public User getUserForm(){
        return new User();
    }

}