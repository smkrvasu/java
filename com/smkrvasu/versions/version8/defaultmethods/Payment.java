package com.smkrvasu.versions.version8.defaultmethods;

public interface Payment {
    void pay(double amt);

    default void printReceipt(double amt) {
        System.out.println(amt);
    }

    static boolean valid(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid");
            return false;
        }
        return true;
    }
}
