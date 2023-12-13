package com.kim.dec08rest.controller;

import com.kim.dec08rest.bean.User;
import com.kim.dec08rest.exception.UserNotFoundException;
import com.kim.dec08rest.repository.UserRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    private UserRepository userRepository;

    public UserJpaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // /jpa/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }
    // jpa/users/{id}
    @GetMapping("/users/{id}")
    public ResponseEntity retrieveAllUsersById(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id" + id);
        }

        EntityModel entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder linTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linTo.withRel("all-users")); // all-users --> http://localhost:8088/users

        return ResponseEntity.ok(entityModel);
    }
}
