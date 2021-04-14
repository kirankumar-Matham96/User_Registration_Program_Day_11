package comUserValidation;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationProgramTest {
    
    @Test
    public void givenFirstName_whenProper_shouldReturnTrue() {
        Assert.assertTrue(UserRegistrationProgram.validateFirstName("Kiran"));
    }
    
    @Test
    public void givenFirstName_whenShort_shouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validateFirstName("Ki"));
    }
    
    @Test
    public void givenFirstName_whenSmallCaseStart_shouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validateFirstName("kiran"));
    }
    
    @Test
    public void givenLastName_whenProper_shouldReturnTrue() {
        Assert.assertTrue(UserRegistrationProgram.validateLastName("Kumar"));
    }
    
    @Test
    public void givenLastName_whenShort_shouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validateFirstName("Ku"));
    }
    
    @Test
    public void givenLastName_whenSmallCaseStart_shouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validateFirstName("kumar"));
    }
    
    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() {
        Assert.assertTrue(UserRegistrationProgram.validateEmail("kiran@gmail.com"));
    }
    
    @Test
    public void givenEmail_WhenNotProper_ShouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validateEmail("kiran@.gmail.com"));
    }
    
    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
        Assert.assertTrue(UserRegistrationProgram.validatePhoneNumber("91 8688332960"));
    }
    
    @Test
    public void givenPhoneNumber_WhenNotProper_ShouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validatePhoneNumber("8688332960"));
    }
    
    @Test
    public void givenPassword_whenProper_shouldReturnTrue() {
        Assert.assertTrue(UserRegistrationProgram.validatePassword("yG95#dhma2se"));
    }
    
    @Test
    public void givenPassword_whenNotProper_shouldReturnFalse() {
        Assert.assertFalse(UserRegistrationProgram.validatePassword("yma2se"));
    }
}

