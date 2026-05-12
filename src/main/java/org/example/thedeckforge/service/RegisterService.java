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
    private final ValidationService validationService;
    @Autowired
    public RegisterService(IUserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }
    public User register(User user) {
        //validateRegisterRequest(user);
        String hashed = BCrypt.hashpw(user.getAuthority().getPassword(), BCrypt.gensalt());
        user.getAuthority().setPassword(hashed);
        userRepository.createUserAuthority(user.getAuthority());
        userRepository.createUser(user);
        user = userRepository.getUserFromAuth(user.getAuthority()); //Her for at sikre at User i programemt og serveren er det samme
        return user;
    }
    private void validateRegisterRequest(User registerRequest) {
        validationService.validate(ValidationType.EMAIL, registerRequest);
        validationService.validate(ValidationType.PASSWORD, registerRequest);
    }
    public User getUserForm(){
        return new User();
    }

}