package za.ac.cput.util;

import org.apache.commons.validator.EmailValidator;

import java.util.Random;
import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String s){

        if (s == null || s.isEmpty()){
            return true;
        }
        return false;

    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isNullorEmpty(String i) {
        return (i == null || i.isEmpty() || i == " ");

    }
    public static boolean isValidEmail(String email ){

        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static long generateRandomLong() {
        Random random = new Random();
        long randomLog = random.nextLong();
        return Math.abs(randomLog);
    }
}
