package com.master.caps.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class LoginParam {


    @NotNull(message = "Please chose your user type")
    @Range(min = 0, max = 2, message = "Please chose your user type")
    private Integer roleType;

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;

}
