package io.github.juliocsrf.restapiwithtests.resources;


import io.github.juliocsrf.restapiwithtests.domain.dto.UserDTO;
import io.github.juliocsrf.restapiwithtests.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok()
                .body(userService.findAll()
                        .stream().map(user -> mapper.map(user, UserDTO.class)).toList()
        );
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(userService.create(user).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
