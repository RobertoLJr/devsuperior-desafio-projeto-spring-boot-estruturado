package com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.service;

import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.model.Role;
import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.model.User;
import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.projection.UserDetailsProjection;
import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.repository.UserRepository;
import jakarta.annotation.Nonnull;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Nonnull
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result =  userRepository.searchUserAndRolesByEmail(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found for username=" + username);
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.getFirst().getPassword());

        result.forEach(projection -> user.addRole(new Role(projection.getRoleId(),  projection.getAuthority())));

        return user;
    }
}
