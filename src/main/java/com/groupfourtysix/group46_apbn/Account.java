package com.groupfourtysix.group46_apbn;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private String accountUserType;
    private String accountEmail;
    private String accountPassword;

    public static ArrayList<Account> accountPassengerArrayList= new ArrayList<>();

    public Account(String accountUserType, String accountEmail, String accountPassword) {
        this.accountUserType = accountUserType;
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
    }

    public String getAccountUserType() {
        return accountUserType;
    }

    public void setAccountUserType(String accountUserType) {
        this.accountUserType = accountUserType;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountUserType='" + accountUserType + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                '}';
    }
}
