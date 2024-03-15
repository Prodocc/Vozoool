package com.vozoool.entity;

import com.vozoool.enums.UserType;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class User {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final UserType userType;
    private final int ID;

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
            default:
                this.userType = UserType.UNKNOWN;
                System.out.println("ERROR");
        }

        ID = (Math.abs(this.hashCode()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public static void main(String[] args) {
        User user = new User("", "", "test@mail.ru", "", 0);
        System.out.println(user.getEmail());
    }
}

