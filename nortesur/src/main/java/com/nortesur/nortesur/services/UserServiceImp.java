package com.nortesur.nortesur.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nortesur.nortesur.entidades.User;
import com.nortesur.nortesur.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User user) {

        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).map(u -> {
                u.setId(u.getId());
                u.setFullname(user.getFullname());
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                u.setBooking(user.getBooking());
                return userRepository.save(u);
            });
        }
        else{
            User newUser = userRepository.save(user);
            Optional <User> optionalUser = Optional.of(newUser);
            return optionalUser;
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
        
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
