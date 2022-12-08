package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.User;
import com.autogator.autogatrorbackend.model.entity.UserEntity;
import com.autogator.autogatrorbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();

    public List<User> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> mapper.map(user, User.class))
                .collect(Collectors.toList());
    }

    public User getUser(Long id) {

        return mapper.map(userRepository.findById(id), User.class);
    }

    public User createUser(User user) {

        return mapper.map(userRepository.save(mapper.map(user, UserEntity.class)), User.class);
    }
}
