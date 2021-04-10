package com.muaccel.testapp.user;

import com.muaccel.testapp.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found!";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_MSG));

        return new UserPrincipal(user);
    }

    public User signUpUser(User user) {

        boolean isUserExist = userRepository.findByEmail(user.getEmail()).isPresent();

        if (isUserExist) {
            throw new RuntimeException("Email is already exist!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.seePassword());

        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }
}
