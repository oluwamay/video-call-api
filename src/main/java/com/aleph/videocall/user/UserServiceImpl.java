package com.aleph.videocall.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private static final List<User> USER_LIST= new ArrayList<>();

    public void register(User user){
        user.setStatus("online");
        USER_LIST.add(user);
        log.info(USER_LIST.toString());
    }

    public User login(User user){
        log.info("User {}",user.toString());
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("User not found"));
        log.info("Index {}", userIndex);
        var cUser = USER_LIST.get(userIndex);
        log.info("Password {}", cUser.getPassword());
        if (!cUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }

    public void logout(String email) {
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
        var cUser = USER_LIST.get(userIndex);
        USER_LIST.get(userIndex).setStatus("offline");
    }

    public List<User> findAll(){
        return USER_LIST;
    }
}
