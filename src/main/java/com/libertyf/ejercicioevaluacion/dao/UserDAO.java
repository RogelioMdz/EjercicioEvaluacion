package com.libertyf.ejercicioevaluacion.dao;

import com.libertyf.ejercicioevaluacion.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
