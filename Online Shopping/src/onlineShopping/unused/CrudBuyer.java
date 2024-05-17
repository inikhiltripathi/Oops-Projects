package onlineShopping.unused;

import onlineShopping.validation.Validation;
import java.io.*;
import java.util.Scanner;

public class CrudBuyer{
/*    Scanner scanner=new Scanner(System.in);

    public boolean show() throws IOException {
        boolean l =false;
        System.out.println("1.Login | 2.Create Account | 3.Exit");
        int key=scanner.nextInt();
        switch (key){
            case 1:l=login();
                break;
            case 2:name();
            mobile();
            email();
            pass();
            l=writeToFile();
            break;
            default:break;
        }
        return l;
    }
    public void name() {
        System.out.println("Enter your Name");
        scanner.nextLine();
        setName(scanner.nextLine());
        if (!Validation.isNotNull(getName())) {
            System.out.println("*-Name cannot be Null");
            name();
        }
    }
    public void mobile() {
        System.out.println("Enter your Mobile");
        setMobile(scanner.nextLine());
        if (!Validation.validateMobile(getMobile()) || !Validation.myHaveSpace(getMobile())){
            System.out.println("*Invalid Mobile Number");
            mobile();
        }
    }
    public void email() {
        System.out.println("Enter your E-mail");
        setEmail(scanner.nextLine());
        if (!Validation.validateEmail(getEmail())) {
            System.out.println("*Invalid E-mail");
            email();
        }
    }
    public void pass(){
        System.out.println("Create your Password");
        setPassword(scanner.nextLine());
        if (!Validation.validatePassword(getPassword())) {
            System.out.println("*Password must be in 4 or more Characters");
            pass();
        }
    }

    public boolean writeToFile() throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\Nikhil Tripathi\\Desktop\\User.txt",true);
        BufferedWriter out = new BufferedWriter(fw);
        out.write("Buyer/"+getName()+"/"+ getMobile()+"/"+getEmail()+"/"+getPassword());
        out.newLine();
        out.close();
        System.out.println("*- Buyer Account created Successfully -*\n");
        return true;
    }
    public boolean login() throws IOException {
        boolean l=false;
        System.out.println("Enter your E-mail Id");
        scanner.nextLine();
        String mail=scanner.nextLine();
        System.out.println("Enter your Password");
        String pass=scanner.nextLine();

        FileReader fr=new FileReader("C:\\Users\\Nikhil Tripathi\\Desktop\\User.txt");
        BufferedReader br=new BufferedReader(fr);
        String str= br.readLine();
        while (str != null){
            String[] s=str.split("/");
            if (s[0].equals("Buyer")&& mail.equals(s[3]) && pass.equals(s[4])) {
                System.out.println("*- Login Successful -*\n");
                l=true;
                break;
            }
            str= br.readLine();
            if (str==null) {
                System.out.println("-> Invalid E-mail or Password <-\n");
                show();
            }
        }
        return l;
    }*/
}
