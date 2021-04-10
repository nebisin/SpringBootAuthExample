package com.muaccel.testapp.registration;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
