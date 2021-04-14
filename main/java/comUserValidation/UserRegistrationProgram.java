package comUserValidation;

import java.util.regex.Pattern;

public class UserRegistrationProgram {
    
    /*
     * UC-1: validating first name
     */
    public static boolean validateFirstName(String firstName) {
        return Pattern.matches("^[A-Z]{1}[a-z]{2,}", firstName);
    }
    
    /*
     * UC-2: validating last name
     */
    public static boolean validateLastName(String lastName) {
        return Pattern.matches("^[A-Z]{1}[a-z]{2,}", lastName);
    }
    
    //main method
    public static void main(String[] args) {
        System.out.println("Welcome to User Registration Simulator!");
        String firstName = "Rahul";
        String lastName = "Rahul";
        System.out.println("first name: " + validateFirstName(firstName));
        System.out.println("last name: " + validateLastName(lastName));
    }
}