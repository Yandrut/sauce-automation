package com.epam.training.student_mykola_koltutskyi.service;

import java.util.ResourceBundle;

public class DataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env", "main"));

    private DataReader(){}

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}