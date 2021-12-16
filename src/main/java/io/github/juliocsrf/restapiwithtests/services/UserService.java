package io.github.juliocsrf.restapiwithtests.services;

import io.github.juliocsrf.restapiwithtests.domain.User;

public interface UserService {

    User findById (Integer id);

}
