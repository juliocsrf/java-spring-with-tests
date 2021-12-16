package io.github.juliocsrf.restapiwithtests.services.impl;

import io.github.juliocsrf.restapiwithtests.domain.User;
import io.github.juliocsrf.restapiwithtests.repositories.UserRepository;
import io.github.juliocsrf.restapiwithtests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }
}
