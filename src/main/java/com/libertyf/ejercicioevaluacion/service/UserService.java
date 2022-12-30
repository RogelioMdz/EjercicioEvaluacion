package com.libertyf.ejercicioevaluacion.service;

import com.libertyf.ejercicioevaluacion.dto.UserDTO;
import com.libertyf.ejercicioevaluacion.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<User> save(User user);
}
