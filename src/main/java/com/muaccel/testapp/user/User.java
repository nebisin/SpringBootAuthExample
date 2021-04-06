package com.muaccel.testapp.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String displayName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;

    private Boolean locked = false;
    private Boolean enabled = true;

    public User(String displayName, String email, String password, UserRole userRole) {
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
