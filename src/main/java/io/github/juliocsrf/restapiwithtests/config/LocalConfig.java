package io.github.juliocsrf.restapiwithtests.config;

import io.github.juliocsrf.restapiwithtests.domain.User;
import io.github.juliocsrf.restapiwithtests.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Julio Cesar", "juliocsrmf@gmail.com", "123");
        User u2 = new User(null, "Joao Gomes", "joaovsb@gmail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
