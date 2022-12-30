package com.libertyf.ejercicioevaluacion.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/liberty")
public class UserController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

}
