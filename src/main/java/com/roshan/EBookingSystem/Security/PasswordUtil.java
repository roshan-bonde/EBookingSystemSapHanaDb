package com.roshan.EBookingSystem.Security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12)); // 12 is the cost factor
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "mySecurePassword";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        boolean isMatch = checkPassword("mySecurePassword", hashedPassword);
        System.out.println("Password Match: " + isMatch);
    }
}

