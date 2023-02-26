package com.example.permissions.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotNull(message = "UserName can not be empty !")
    private String username;
    @NotNull(message = "Password can not be empty !")
    private String password;
}
