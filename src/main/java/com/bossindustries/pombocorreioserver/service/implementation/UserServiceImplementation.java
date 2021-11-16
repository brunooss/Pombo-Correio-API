package com.bossindustries.pombocorreioserver.service.implementation;

import com.bossindustries.pombocorreioserver.model.User;
import com.bossindustries.pombocorreioserver.repository.UserRepository;
import com.bossindustries.pombocorreioserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static org.springframework.data.domain.PageRequest.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        log.info("Creating new user: {}", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Collection<User> usersList(int limit) {
        log.info("Retrieving all users...");
        return userRepository.findAll(of(0, limit)).toList();
    }

    @Override
    public User getUser(Long id) {
        log.info("Retrieving user by id: {}", id);
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        log.info("Updating user: {}", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        log.info("Deleting user: {}", id);
        userRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
