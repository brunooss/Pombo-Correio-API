package com.bossindustries.pombocorreioserver.service;

import com.bossindustries.pombocorreioserver.model.User;

import java.util.Collection;

public interface UserService {
    User createUser(User user);
    Collection<User> usersList(int limit);
    User getUser(Long id);
    User updateUser(User user);
    Boolean deleteUser(Long id);
}
