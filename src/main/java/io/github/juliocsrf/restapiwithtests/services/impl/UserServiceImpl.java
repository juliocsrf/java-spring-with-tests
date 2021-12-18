package io.github.juliocsrf.restapiwithtests.services.impl;

import io.github.juliocsrf.restapiwithtests.domain.User;
import io.github.juliocsrf.restapiwithtests.domain.dto.UserDTO;
import io.github.juliocsrf.restapiwithtests.repositories.UserRepository;
import io.github.juliocsrf.restapiwithtests.services.UserService;
import io.github.juliocsrf.restapiwithtests.services.exceptions.DataIntegratyViolationException;
import io.github.juliocsrf.restapiwithtests.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        verifyEmail(userDTO);
        return repository.save(mapper.map(userDTO, User.class));
    }

    @Override
    public User update(UserDTO userDTO) {
        verifyEmail(userDTO);
        return repository.save(mapper.map(userDTO, User.class));
    }

    private void verifyEmail(UserDTO userDTO) {
        Optional<User> user = repository.findByEmail(userDTO.getEmail());
        if(user.isPresent() && !user.get().getId().equals(userDTO.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
