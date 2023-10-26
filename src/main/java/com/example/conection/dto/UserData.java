package com.example.conection.dto;

import com.example.conection.Modelo.user.User;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    private User user;

    private String Token;

}
