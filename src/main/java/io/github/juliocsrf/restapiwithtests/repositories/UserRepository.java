package io.github.juliocsrf.restapiwithtests.repositories;

import io.github.juliocsrf.restapiwithtests.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
