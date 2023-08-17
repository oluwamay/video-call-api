package com.aleph.videocall.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String status;
    private String email;
    private String password;
    private String username;
}
