package com.epam.training.student_mykola_koltutskyi.service;

import com.epam.training.student_mykola_koltutskyi.models.User;

public class UserCreator {

    private UserCreator() {}

    public static User createUserWithAnyCredentials() {
        return new User("problem_user", "qwerty123!@#");
    }

    public static User createUserWithValidCredentials() {
        return new User("standard_user", "secret_sauce");
    }
}