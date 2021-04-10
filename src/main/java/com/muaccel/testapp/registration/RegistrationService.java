package com.muaccel.testapp.registration;

import com.muaccel.testapp.user.User;
import com.muaccel.testapp.user.UserRepository;
import com.muaccel.testapp.user.UserRole;
import com.muaccel.testapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private UserService userService;
    private final UserRepository userRepository;

    public User register(AuthenticationRequest request) {
        return userService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
