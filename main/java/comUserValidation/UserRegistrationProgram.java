package comUserValidation;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserRegistrationProgram {
    
    /*
     * UC-1: validating first name
     */
    public static boolean validateFirstName(String firstName) {
        boolean result = false;
        try {
            if(firstName == null) {
                throw new UserRegistrationException("first name is null! Please give some name");
            }
            if(firstName.equals("")) {
                throw new UserRegistrationException("first name can't be empty!");
            }
            result = Pattern.matches("^[A-Z]{1}[a-z]{2,}", firstName);
        } catch(UserRegistrationException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /*
     * UC-2: validating last name
     */
    public static boolean validateLastName(String lastName) {
        boolean result = false;
        try {
            if(lastName == null) {
                throw new UserRegistrationException("last name is null! Please give some name");
            }
            if(lastName.equals("")) {
                throw new UserRegistrationException("last name can't be empty!");
            }
            result = Pattern.matches("^[A-Z]{1}[a-z]{2,}", lastName);
        } catch(UserRegistrationException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /*
     * UC-3: validating email
     */
    public static boolean validateEmail(String email) {
        boolean result = false;
        try {
            if(email == null) {
                throw new UserRegistrationException("email is null! Please enter valid email");
            }
            if(email.equals("")) {
                throw new UserRegistrationException("email can't be empty!");
            }
            result = Pattern.matches("^(?!\\.)[A-Za-z0-9]+([._%+-]?[0-9])*@[A-Za-z0-9-]+\\.[a-zA-Z]{2,}(\\.[A-Za-z]{2,})?$", email);
        } catch(UserRegistrationException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /*
     * UC-4: validating mobile number
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        boolean result = false;
        try {
            if(phoneNumber == null) {
                throw new UserRegistrationException("phone number is null! Please enter valid phone number");
            }
            if(phoneNumber.equals("")) {
                throw new UserRegistrationException("phone number can't be empty!");
            }
            result = Pattern.matches("^[91]{2}\\s[0-9]{10}", phoneNumber);
        } catch(UserRegistrationException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /*
     * UC-5,6,7: validating password
     *
     *  Rule1: minimum 8 characters
     *  Rule2: minimum 1 upper-case
     *  Rule3: minimum 1 numeric value
     *  Rule4: Exactly 1 special character
     */
    public static boolean validatePassword(String password) {
        boolean result = false;
        try {
            if(password == null) {
                throw new UserRegistrationException("password is null! Please enter valid password");
            }
            if(password.equals("")) {
                throw new UserRegistrationException("password can't be empty!");
            }
            String[] regexExpressions = {"[@|#|$|%|&]{1,1}[a-zA-Z0-9]$ " +
                                         "| [a-zA-Z0-9][@|#|$|%|&]{1,1}[a-zA-Z0-9]$ " +
                                         "| [a-zA-Z0-9][@|#|$|%|&]{1,1}$",
                                         "(?=.[A-Z])(?=.[0-9])(?=.*[@|#|$|%|&])[A-Za-z0-9@#$%&]{8,}$"};
            for(String regex : regexExpressions) {
                if(password.matches(regex)) {
                    result =  true;
                }
            }
        } catch(UserRegistrationException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /*
     * UC-9: All types of email
     * adding email to array-list and calling validateEmail method
     */
    public static void addToEmailList(String emailToAdd) {
        ArrayList<String> email = new ArrayList<String>();
        
        email.add(emailToAdd);
        
        for(int i = 0; i < email.size(); i++) {
            System.out.println(email.get(i) + ": " + validateEmail(email.get(i)));
        }
    }
    
    //main method
    public static void main(String[] args) {
        System.out.println("Welcome to User Registration Simulator!");
        String firstName = "Rahul";
        String lastName = "Rahul";
        String phoneNumber = "91 8688332960";
        String email = "rahul@gmail.com";
        String password = "kjgte$rS6sfk";
        
        //validation
        System.out.println("first name: " + validateFirstName(firstName));
        System.out.println("last name: " + validateLastName(lastName));
        System.out.println("email: " + validateEmail(email));
        System.out.println("password: " + validatePassword(password));
        System.out.println("phone number: " + validatePhoneNumber(phoneNumber));
    
        //valid email
        addToEmailList("Rahul@gmail.com");
        addToEmailList("Rahul-100@gmail.com");
        addToEmailList("Rahul.100@gmail.com");
        addToEmailList("Rahul-100@Rahul.com");
        addToEmailList("Rahul-100@Rahul.net");
        addToEmailList("Rahul.100@Rahul.com.au");
        addToEmailList("Rahul@1.com");
        addToEmailList("Rahul@gmail.com.com");
        addToEmailList("Rahul+100@yahoo.com");
    
        //invalid email
        addToEmailList("Rahul@.com.my");
        addToEmailList("Rahul123@gmail.a");
        addToEmailList("Rahul123@.com");
        addToEmailList("Rahul123@.com.com");
        addToEmailList(".Rahul@Rahul.com");
        addToEmailList("Rahul()*@gmail.com");
        addToEmailList("Rahul@%*.com");
        addToEmailList("Rahul..2002@gmail.com");
        addToEmailList("Rahul.@gmail.com");
        addToEmailList("Rahul@Rahul@gmail.com");
        addToEmailList("Rahul@gmail.com.1a");
        addToEmailList("Rahul@gmail.com.aa.au");
    }
}