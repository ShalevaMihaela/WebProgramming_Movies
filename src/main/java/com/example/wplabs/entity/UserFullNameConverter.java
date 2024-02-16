package com.example.wplabs.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserFullNameConverter implements AttributeConverter<UserFullName, String> {



    @Override
    public String convertToDatabaseColumn(UserFullName userFullName) {
        return userFullName.getName() + " " + userFullName.getSurname();
    }


    @Override
    public UserFullName convertToEntityAttribute(String s) {
        String name = s.split("\\s+")[0];
        String surname = s.split("\\s+")[1];
        return new UserFullName(name, surname);
    }
}
