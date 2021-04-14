package comUserValidation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmailTestParameterized {
    
    private String email;
    private String expected;
    
    public EmailTestParameterized(String email, String expected) {
        this.email = email;
        this.expected = expected;
    }
    
    @Parameterized.Parameters
    public static Collection emailInput(){
        return Arrays.asList(new Object[][]
                {{"Rahul@gmail.com",true},
                {"Rahul-100@gmail.com",true},
                {"Rahul.100@gmail.com",true},
                {"Rahul-100@Rahul.com",true},
                {"Rahul-100@Rahul.net",true},
                {"Rahul.100@Rahul.com.au",true},
                {"Rahul@1.com",true},
                {"Rahul@gmail.com.com",true},
                {"Rahul+100@yahoo.com",true},
                {"Rahul@gmail.com.aa.au",false},
                {"Rahul@.com.my",false},
                {"Rahul123@gmail.a",false},
                {"Rahul123@.com",false},
                {"Rahul123@.com.com",false},
                {".Rahul@Rahul.com",false},
                {"Rahul()*@gmail.com",false},
                {"Rahul@%*.com",false},
                {"Rahul..2002@gmail.com",false},
                {"Rahul.@gmail.com",false},
                {"Rahul@Rahul@gmail.com",false},
                {"Rahul@gmail.com.1a",false},});
    }
    
    @Test
    public void givenProperEmail_returnsTrue() {
        Assert.assertEquals(expected,UserRegistrationProgram.validateEmail(email));
    }
}
