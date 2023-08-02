package com.fethi.springbootsecurityjwt.service;

import com.fethi.springbootsecurityjwt.models.ERole;
import com.fethi.springbootsecurityjwt.models.Role;
import com.fethi.springbootsecurityjwt.models.User;
import com.fethi.springbootsecurityjwt.service.exception.InvalidPasswordException;
import com.fethi.springbootsecurityjwt.payload.request.SignupRequest;
import com.fethi.springbootsecurityjwt.repository.RoleRepository;
import com.fethi.springbootsecurityjwt.repository.UserRepository;
import com.fethi.springbootsecurityjwt.service.exception.EmailAlreadyUsedException;
import com.fethi.springbootsecurityjwt.service.exception.UsernameAlreadyUsedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserService {


    private final UserRepository userRepository;


    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public void registerUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyUsedException();
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyUsedException();
        }
        User user = new User(request.getUsername(), request.getEmail(),
                encoder.encode(request.getPassword()));


        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }
    public void changePassword(String currentClearTextPassword, String newPassword){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl login = (UserDetailsImpl) auth.getPrincipal();
        userRepository.findByUsername(login.getUsername()).ifPresent( user -> {
            String currentEncryptedPassword = user.getPassword();
            if (!encoder.matches(currentClearTextPassword, currentEncryptedPassword)) {
                throw new InvalidPasswordException();
            }
            String encryptedPassword = encoder.encode(newPassword);
            user.setPassword(encryptedPassword);
        });
    }
}
