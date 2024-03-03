package com.vozoool.enums;

public enum UserType {
    ADMIN(0), CUSTOMER(1), SELLER(2);
    final int value;

    UserType(int value) {
        this.value = value;
    }
}
