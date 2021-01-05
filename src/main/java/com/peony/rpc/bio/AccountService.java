package com.peony.rpc.bio;

public class AccountService {

    public String createAccount() {
        System.out.println("create account...");
        return "createAccount";
    }

    public String loadAccount() {
        System.out.println("load account...");
        return "loadAccount";
    }
}
