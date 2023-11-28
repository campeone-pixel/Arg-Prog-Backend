package com.example.conection.authentication.dto;

import com.example.conection.authentication.modelo.user.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    private User user;

    private List Token;

}
