package com.aleph.videocall.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class UserController {
    private final UserService service;
    @GetMapping()
    public List<User> findAll(){
       return service.findAll();
    }
    @PostMapping("/logout")
    public void logout(@RequestBody String email){
        service.logout(email);
    }
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return service.login(user);
    }
    @PostMapping("/register")
    public void register(@RequestBody User user){
        service.register(user);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
