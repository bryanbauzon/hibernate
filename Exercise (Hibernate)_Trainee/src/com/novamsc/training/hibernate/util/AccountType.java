package com.novamsc.training.hibernate.util;

public enum AccountType
{
    SAVINGS('S'), CHECKING('C');

    private char type;

    AccountType(char type) {
        this.type = type;
    }

    public char toChar() {
        return type;
    }

    public static AccountType fromChar(char type) {
        switch (type) {
        case 'S':
            return SAVINGS;
        case 'C':
            return CHECKING;
         default:
             return SAVINGS;
        }
    }
}
