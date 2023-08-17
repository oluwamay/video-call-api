package com.aleph.videocall.user;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void logout(String email);
    User login(User user);
    void register(User user);
}
