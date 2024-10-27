package com.epam.training.student_mykola_koltutskyi.configuration;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserType implements Converter <BrowserType> {

    @Override
    public BrowserType convert(Method method, String nameOfTheBrowser) {
        Map<String, BrowserType> browserTypes = Map.
                of("CHROME", BrowserType.CHROME,
                "FIREFOX", BrowserType.FIREFOX);
        return browserTypes.getOrDefault(nameOfTheBrowser, BrowserType.CHROME);
    }
}