package io.github.juliocsrf.restapiwithtests.services;

import io.github.juliocsrf.restapiwithtests.domain.User;

import java.util.List;

public interface UserService {

    User findById (Integer id);
    List<User> findAll();

}
