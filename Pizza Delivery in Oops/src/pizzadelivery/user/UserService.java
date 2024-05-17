package pizzadelivery.user;

import java.io.IOException;
import java.util.Scanner;

import pizzadelivery.product.CartService;
import pizzadelivery.product.ProductService;
import pizzadelivery.utility.File;
import pizzadelivery.utility.Validation;
import pizzadelivery.utility.Verify;

public class UserService {

    String m,p;
    Scanner sc = new Scanner(System.in);
    CartService c = CartService.getObj();
    UserBean b = UserBean.getObj();

    private static UserService obj;
    private UserService(){}
    public static synchronized UserService getObj(){
        if (obj == null) {
            obj = new UserService();
        }
        return obj;
    }

    public void login(boolean admin) throws IOException {

        System.out.println("Enter Your Email Id");
        m = sc.nextLine();
        System.out.println("Enter Your Password");
        p = sc.nextLine();

        String s = Verify.login(admin, m, p);

        switch (s) {
            case "Admin" -> AdminService.getObj().show();
            case "User" -> {
                ProductService.getObj().productList();
                userOperation();
            }
            default -> {
                System.out.println("*Invalid Email or Password");
                Controller.getObj().user();
            }
        }
    }

    public void register(boolean admin) {
        int i = 0;
        do {
            if (i == 1) {
                System.out.println("*Invalid Name");
            }
            i = 1;
            System.out.println("Enter Your Name");
            UserBean.getObj().setName(sc.nextLine());
        } while (!Validation.isNotNull(b.getName()));

        do {
            if (i == 2) {
                System.out.println("*Invalid Mobile No.");
            }
            i = 2;
            System.out.println("Enter Your Mobile Number");
            UserBean.getObj().setMobile(sc.nextLine());
        } while (!Validation.validateMobile(b.getMobile()));

        do {
            if (i == 3) {
                System.out.println("*Invalid Email");
            }
            i = 3;
            System.out.println("Enter Your Email Id");
            UserBean.getObj().setEmail(sc.nextLine());
        } while (!Validation.validateEmail(b.getEmail()));

        do {
            if (i == 4) {
                System.out.println("*Invalid Password");
            }
            i = 4;
            System.out.println("Create a Password");
            UserBean.getObj().setPassword(sc.nextLine());
        } while (!Validation.isNotNull(b.getPassword()) || !Validation.validatePassword(b.getPassword()));

        if (admin) {
            try {
                File.writeAdmin(b.getName(), b.getMobile(), b.getEmail(), b.getPassword());
                System.out.println("Admin account created successfully");
                AdminService.getObj().show();
            } catch (IOException e) {
                System.out.println("Error in writing into File "+e);
            }
        } else {
            try {
                File.writeUser(b.getName(), b.getMobile(), b.getEmail(), b.getPassword());
                System.out.println("Account created successfully");
                m=b.getEmail();
                p=b.getPassword();
            } catch (IOException e) {
                System.out.println("Error in writing into File "+e);
            }
        }

    }

    public void userOperation() throws IOException{
        System.out.println("---------------------------------------");
        System.out.println("1.Order | 2.Add To Cart | 3.View Orders");
        System.out.println("4.View Cart | 5.Exit");
        int k = sc.nextInt();

        switch(k){
            case 1 -> {
                c.order(m, p);
                userOperation();
            }    
            case 2 -> {
                c.addToCart(m, p);
                userOperation();
            }
            case 3 -> {
                c.viewOrdersById(m, p);
                userOperation();
            }
            case 4 -> {
                c.viewCart(m, p);
                userOperation();
            }    
            default -> {
                System.out.println("*ThankYou Visit Again");
            }

        }
    }
}
