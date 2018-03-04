package com.springboot.springbootblog.repository;

import com.springboot.springbootblog.domain.User;

import java.util.List;

public interface UserRepository {
    User saveOrUpdateUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> getListUsers();
}
