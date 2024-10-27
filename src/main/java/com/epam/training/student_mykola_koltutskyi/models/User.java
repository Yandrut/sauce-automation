package com.epam.training.student_mykola_koltutskyi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private final String username;
    private final String password;
}
