package pizzadelivery.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import pizzadelivery.product.CartService;
import pizzadelivery.product.ProductService;
import pizzadelivery.utility.File;

public class AdminService {

    Scanner sc = new Scanner(System.in);
    private static AdminService obj;
    private AdminService(){}
    public static synchronized AdminService getObj(){
        if (obj == null) {
            obj = new AdminService();
        }
        return obj;
    }

    public void show() throws IOException{
        
        System.out.println("---------------------------------------------");
        System.out.println("1.Add Products | 2.View All Products");
        System.out.println("3.Add New Admin | 4.View Users List");
        System.out.println("5.View All Orders | 6.Exit");

        int k = sc.nextInt();
        switch(k){
            case 1 -> {
                ProductService.getObj().addProduct();
                show();
            }    
            case 2 -> {
                ProductService.getObj().productList();
                show();
            }
            case 3 -> {
                UserService.getObj().register(true); 
                show();
            }    
            case 4 -> usersList();
            case 5 -> {
                CartService.getObj().viewAllOrders();
                show();
            }
            default -> System.out.println("Thankyou and Visit Again");
        }

        
    }

    
    public void usersList() throws IOException{

        BufferedReader br = File.readUser();
        String line = br.readLine();

        while (line != null) {
            String[] s = line.split("/");
            if (s[0].equals("Admin")) {
                System.out.println("["+s[0]+" Name - "+s[1]+"Mobile - "+s[2]+"E-mail - "+s[3]+" ]");
            } else {
                System.out.println("[Name - "+s[0]+"Mobile - "+s[1]+"E-mail - "+s[2]+" ]");
            }
            line = br.readLine();
        }
        show();
        
    }

}
