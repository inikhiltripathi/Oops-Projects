package pizzadelivery.utility;

import java.io.BufferedReader;
import java.io.IOException;

public class Verify {

    
    public static boolean admin() throws IOException{
        BufferedReader br=File.readUser();
        String str= br.readLine();
        while (str != null){
            String[] s=str.split("/");
            if (s[0].equals("Admin")) {
                return true;
            }
            str= br.readLine();
        }
        return false;
    }

    public static String login(boolean b, String e, String p) throws IOException{
        BufferedReader br=File.readUser();
        String str= br.readLine();
        while (str != null){
            String[] s=str.split("/");
            
            if (b && e.equals(s[3]) && p.equals(s[4])) {
                System.out.println("Login Successful");
                return "Admin";
            }else{
                if (e.equals(s[2]) && p.equals(s[3])) {
                    System.out.println("Login Successfull");
                    return "User";
                }
            }
            str= br.readLine();   
        }
        return "False";
    }



}
