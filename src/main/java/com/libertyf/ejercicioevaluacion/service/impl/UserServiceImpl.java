package com.libertyf.ejercicioevaluacion.service.impl;

import com.libertyf.ejercicioevaluacion.dao.UserDAO;
import com.libertyf.ejercicioevaluacion.entity.User;
import com.libertyf.ejercicioevaluacion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public User save(User user) {
        return userDAO.save(user);
    }
}
