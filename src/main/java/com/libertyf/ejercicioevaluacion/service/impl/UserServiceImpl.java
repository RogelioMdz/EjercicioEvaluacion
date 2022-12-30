package com.libertyf.ejercicioevaluacion.service.impl;

import com.libertyf.ejercicioevaluacion.dao.UserDAO;
import com.libertyf.ejercicioevaluacion.entity.User;
import com.libertyf.ejercicioevaluacion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
