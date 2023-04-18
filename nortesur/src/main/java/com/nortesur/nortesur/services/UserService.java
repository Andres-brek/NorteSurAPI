package com.nortesur.nortesur.services;

import java.util.List;
import java.util.Optional;

import com.nortesur.nortesur.entidades.User;


public interface UserService {
    public User createUser(User user);
    public Optional<User> updateUser(Long id,User user);
    public void deleteUser(Long id);
    public User getUser(Long id);
    public List<User> getAllUsers();
}
