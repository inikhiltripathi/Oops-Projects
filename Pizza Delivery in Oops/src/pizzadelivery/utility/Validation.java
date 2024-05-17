package pizzadelivery.utility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {



    private static Pattern pattern;
    private static Matcher matcher;

    //Email Pattern
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate Email with regular expression
     *
     * @param email
     * @return true for Valid Email and false for Invalid Email
     */

    public static boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Checks for Null String object
     *
     * @param txt
     * @return true for not null and false for null String object
     */
    public static boolean isNotNull(String txt) {
        return txt != null && txt.trim().length() > 0 ? true : false;
    }

    // validating password with retype password
    public static boolean validatePassword(String pass) {
        if (pass != null && pass.length() > 3) {
            return true;
        }
        return false;
    }


    public static boolean haveSpace(String userName) {

        boolean checkSpace=false;
        int f=0;
        for(int i=0;i<userName.length();i++){
            if(userName.contains(" ") ){
                f=1;
                checkSpace= true;
            }
        }
        if(f==1){
            return checkSpace;

        }else{
            return checkSpace;
        }


    }
    public static boolean validateMaxMobile(String mobile) {
        if (mobile != null && mobile.length() > 10) {
            return true;
        }
        return false;
    }

    public static boolean validateMinMobile(String mobile)
    {
        if (mobile != null && mobile.length() < 10) {
            return true;
        }
        return false;
    }
    public static boolean validateMobile(String mobile) {
        if (mobile != null && mobile.length() == 10) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean myHaveSpace(String mobile) {
        int f=0;
        for(int i=0;i<mobile.length();i++){
            if(mobile.contains(" ") ) {
                f=1;
                break;
            }
        }
        if (f==1) {
            return false;
        }else {
            return true;
        }

    }
}