package com.muaccel.testapp.registration;

import com.muaccel.testapp.user.User;
import com.muaccel.testapp.user.UserPrincipal;
import com.muaccel.testapp.user.UserRole;
import com.muaccel.testapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private UserService userService;

    public User register(RegistrationRequest request) {
        return userService.signUpUser(
                new User(
                        request.getDisplayName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
