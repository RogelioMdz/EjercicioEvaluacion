package com.libertyf.ejercicioevaluacion.controller;

import com.libertyf.ejercicioevaluacion.entity.User;
import com.libertyf.ejercicioevaluacion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api/liberty")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<User> existUser = userService.findById(id);
        if (!existUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(existUser);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
        Optional<User> existUser = userService.findById(id);
        if (!existUser.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            existUser.get().setName(user.getName());
            existUser.get().setEmail(user.getEmail());
            existUser.get().setSecondaryEmail(user.getSecondaryEmail());
            existUser.get().setGender(user.getGender());
            existUser.get().setStatus(user.getStatus());
            existUser.get().setPhoto(user.getPhoto());
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(existUser.get()));
        }
    }
}
