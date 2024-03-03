package com.vozoool.entity;

import com.vozoool.enums.UserType;
import lombok.ToString;

import java.util.Objects;
@ToString
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;
    private final int ID;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public int getID() {
        return ID;
    }

    public User(String name, String surname, String email, String password, int userType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        switch (userType) {
            case 0:
                this.userType = UserType.ADMIN;
                break;
            case 1:
                this.userType = UserType.CUSTOMER;
                break;
            case 2:
                this.userType = UserType.SELLER;
                break;
        }

        ID = (Math.abs(this.hashCode()));
    }

    //TODO Rewrite hashcode for ID
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}

