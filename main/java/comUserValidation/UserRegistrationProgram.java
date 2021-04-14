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
    
    /*
     * UC-3: validating email
     */
    public static boolean validateEmail(String email) {
        return Pattern.matches("^(?!\\.)[A-Za-z0-9]+([._%+-]?[0-9])*@[A-Za-z0-9-]+\\.[a-zA-Z]{2,}(\\.[A-Za-z]{2,})?$", email);
    }
    
    /*
     * UC-4: validating mobile number
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches("^[91]{2}\\s[0-9]{10}", phoneNumber);
    }
    
    /*
     * UC-5,6,7: validating password
     *
     *  Rule1: minimum 8 characters
     *  Rule2: minimum 1 upper-case
     *  Rule3: minimum 1 numeric value
     */
    public static boolean validatePassword(String password) {
        return Pattern.matches("(?=.*[A-Z])(?=.*[0-9]).{8,}",password);
    }
    
    //main method
    public static void main(String[] args) {
        System.out.println("Welcome to User Registration Simulator!");
        String firstName = "Rahul";
        String lastName = "Rahul";
        String phoneNumber = "91 8688332960";
        String email = "rahul@gmail.com";
        String password = "kjgterS6sfk";
        System.out.println("first name: " + validateFirstName(firstName));
        System.out.println("last name: " + validateLastName(lastName));
        System.out.println("email: " + validateEmail(email));
        System.out.println("password: " + validatePassword(password));
        System.out.println("phone number: " + validatePhoneNumber(phoneNumber));
    }
}