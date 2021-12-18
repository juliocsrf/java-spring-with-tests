package io.github.juliocsrf.restapiwithtests.services;

import io.github.juliocsrf.restapiwithtests.domain.User;
import io.github.juliocsrf.restapiwithtests.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO userDTO);
    User update(UserDTO userDTO);

}
