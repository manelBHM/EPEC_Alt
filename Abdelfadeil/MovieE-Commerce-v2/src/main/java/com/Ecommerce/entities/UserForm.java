package com.Ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserForm {

    public String email;
    private String username;
	private String password;
	private String repassword;

}
