package com.muaccel.testapp.registration;

import com.muaccel.testapp.user.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public User register(@RequestBody @Valid AuthenticationRequest request) {
        return registrationService.register(request);
    }
}
