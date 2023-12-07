package utils;

import lombok.Data;

@Data
public class User {
    private String email;
    private String fullName;
    private String username;
    private String password;
    private String role;
}