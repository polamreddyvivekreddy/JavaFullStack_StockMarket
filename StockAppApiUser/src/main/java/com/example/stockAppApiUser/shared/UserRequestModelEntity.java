package com.example.stockAppApiUser.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModelEntity {
    private String firstName;
    private String lastName;
    private String email;
}
