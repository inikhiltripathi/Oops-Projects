package onlineShopping.crud;

import onlineShopping.bean.UserAdmin;
import onlineShopping.readWrite.ReadWrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class CrudAdmin extends UserAdmin {
    Scanner scanner=new Scanner(System.in);

    public boolean show() throws IOException {
        boolean b=false;
        System.out.println("1.Login | 2.Create Account | 3.Back");
        int i=scanner.nextInt();
        switch (i){
            case 1:b=login();
                break;
            case 2:b=createAdmin();
            break;
            default:break;
        }
        return b;
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
            if (mail.equals(s[3]) && pass.equals(s[4])) {
                System.out.println("*- Login Successful -*\n");
                l=true;
                CrudProduct.loginInfo(mail,pass);
                break;
            }
            str= br.readLine();
            if (str==null) {
                System.out.println("-> Invalid E-mail or Password <-\n");
                show();
            }
        }
        return l;
    }
    public void writeToFile() throws IOException {
        ReadWrite.writeAdmin(getName(),getMobile(),getEmail(),getPassword());
        System.out.println("*- Account created Successfully -*\n");
        CrudProduct.loginInfo(getEmail(),getPassword());
    }
    public boolean createAdmin() throws IOException{
        boolean a=false,x=false;
        BufferedReader b=ReadWrite.readUser();
        String read=b.readLine();
        while (read!=null){
            String[] s=read.split("/");
            if (s[0].equals("Admin")){
                System.out.println("-> Only Existing Admin can Add New Admin <-");
                a=true;
                show();
            }
            read =b.readLine();
        }
        if (!a){
            name();
            mobile();
            email();
            pass();
            writeToFile();
            x=true;
        }
        return x;
    }

    public int adminOperation(){
        int l=0;
        System.out.println("1.Buy Products | 2.Sell Own Products | 3.View Own Products");
        System.out.println("4.Add New Admin | 5.View Product List | 6.View User List");
        System.out.println("7.Remove Product | 8.Remove User | 9.Exit");
        int i=scanner.nextInt();
        switch (i){
            case 1:l=1;
            break;
            case 2:l=2;
            break;
            case 3:l=3;
            break;
            case 4:l=4;
            break;
            case 5:l=5;
            break;
            case 6:l=6;
            default:break;
        }
        return l;
    }

}
