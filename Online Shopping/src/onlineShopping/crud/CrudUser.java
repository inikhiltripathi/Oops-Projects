package onlineShopping.crud;

import onlineShopping.bean.UserAdmin;
import onlineShopping.readWrite.ReadWrite;

import java.io.*;
import java.util.Scanner;

public class CrudUser extends UserAdmin {
    Scanner scanner=new Scanner(System.in);

    public boolean createUser() throws IOException {
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
    public boolean writeToFile() throws IOException {
        ReadWrite.writeUser(getName(),getMobile(),getEmail(),getPassword());
        System.out.println("*- Account created Successfully -*\n");
        CrudProduct.loginInfo(getEmail(),getPassword());
        return true;
    }
    public boolean login() throws IOException {
        boolean l=false;
        System.out.println("Enter your E-mail Id");
        scanner.nextLine();
        String mail=scanner.nextLine();
        System.out.println("Enter your Password");
        String pass=scanner.nextLine();

        BufferedReader br=ReadWrite.readUser();
        String str= br.readLine();
        while (str != null){
            String[] s=str.split("/");
            if (mail.equals(s[2]) && pass.equals(s[3])) {
                System.out.println("*- Login Successful -*\n");
                l=true;
                CrudProduct.loginInfo(mail,pass);
                break;
            }
            str= br.readLine();
            if (str==null) {
                System.out.println("-> Invalid E-mail or Password <-\n");
                createUser();
            }
        }
        return l;
    }
}
