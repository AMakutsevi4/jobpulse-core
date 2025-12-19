package ru.jobpulse.core.infrastructure.persistence.repository.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.jobpulse.core.domain.model.user.User;
import ru.jobpulse.core.domain.repository.UserRepository;
import ru.jobpulse.core.infrastructure.persistence.entity.UserEntity;
import ru.jobpulse.core.infrastructure.persistence.mapper.UserMapper;
import ru.jobpulse.core.infrastructure.persistence.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;
    private final UserDetailsService userDetailsService;

    @Override
    public void save(User user) {
        jpaRepository.save(mapper.toEntity(user));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
//
//    public User getUserByPhoneNumber(String phoneNumber) {
//        return userRepository.getUserByPhoneNumber(phoneNumber).orElseThrow(()
//                -> new EntityNotFoundException("User with phone number: " + phoneNumber + " not found"));
//    }
//
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user;
//
//        if (username.matches("^\\+?[0-9\\-\\s]*$")) {
//            user = getUserByPhoneNumber(username);
//
//            return new org.springframework.security.core.userdetails.User(
//                    user.getPhoneNumber(),
//                    String.valueOf(user.getPassword()),
//                    user.getRoles()
//                            .stream()
//                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).toList()
//            );
//        } else if (username.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
//            user = getUserByEmail(username);
//
//            return new org.springframework.security.core.userdetails.User(
//                    user.getEmail(),
//                    String.valueOf(user.getPassword()),
//                    user.getRoles()
//                            .stream()
//                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).toList()
//            );
//        } else
//            throw new IllegalArgumentException("Логин не соответствует номеру телефона или email адресу");
//    }
}