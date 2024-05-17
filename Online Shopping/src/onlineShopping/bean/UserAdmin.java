package onlineShopping.bean;

import onlineShopping.validation.Validation;

import java.util.Scanner;

public class UserAdmin {
    Scanner scanner=new Scanner(System.in);
    private String name,mobile,email,password;

    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public void name() {
        System.out.println("Enter your Name");
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
            System.out.println("-> Invalid Mobile Number <-");
            mobile();
        }
    }
    public void email() {
        System.out.println("Enter your E-mail");
        setEmail(scanner.nextLine());
        if (!Validation.validateEmail(getEmail())) {
            System.out.println("-> Invalid E-mail <-");
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

}
