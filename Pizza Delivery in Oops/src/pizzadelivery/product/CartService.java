package pizzadelivery.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import pizzadelivery.utility.File;

public class CartService {

    private String name;
    private int price;
    Scanner sc = new Scanner(System.in);
    private static CartService obj;
    private CartService(){}
    public static synchronized CartService getObj(){
        if (obj == null) {
            obj = new CartService();
        }
        return obj;
    }

    public boolean getProductById(int id) throws IOException{
        String i = Integer.toString(id);
        BufferedReader br = File.readProduct();
        String line = br.readLine();
        while (line != null) {
            String []s = line.split("/");
            if (s[0].equals(i)) {
                name=s[1];
                price=Integer.parseInt(s[4]);
                return true;
            }
            line = br.readLine();
        }
        return false;
    }

    public void order(String m,String p) throws IOException{
        System.out.println("Enter Product Id");
        int id = sc.nextInt();
        System.out.println("Enter Your Address");
        sc.nextLine();
        String add = sc.nextLine();
        if (getProductById(id)) {
            File.writeOrder(m, p, id, name, price, add);
            System.out.println("Product will deliver as soon as possible");
            
        }else{
            System.out.println("Invalid Product Id");
            
        }
    }

    public void addToCart(String m,String p) throws IOException{
        System.out.println("Enter Product Id");
        int id = sc.nextInt();
        if (getProductById(id)) {
            File.writeCart(m, p, id, name, price);
            System.out.println("Product Added to cart Successfully");
            
        } else {
            System.out.println("Invalid Product Id");
            
        }
    }

    public void viewCart(String m, String p) throws IOException{
        int count = 0;
        int amount = 0;
        System.out.println("-----------------------------------------------");
        BufferedReader br = File.readCart();
        String line = br.readLine();
        while (line != null) {
            String []s=line.split("/");
            if (m.equals(s[0]) && p.equals(s[1])) {
                count++;
                amount=amount+Integer.parseInt(s[4]);
                System.out.println("[ Id."+s[2]+" | "+s[3]+" | Price."+s[4]+"Rs ]");
            }
            line = br.readLine();
        }
        System.out.println("Total Product = "+count+" | Total Price = "+amount);
    }

    public void viewOrdersById(String m, String p) throws IOException{
        System.out.println("----------Your Orders-------------");
        int c=0;
        BufferedReader br = File.readOrders();
        String line = br.readLine();
        while (line != null) {
            String []s=line.split("/");
            if (m.equals(s[0]) && p.equals(s[1])) {
                c++;
                System.out.println("[ Id."+s[2]+" | "+s[3]+" | Price."+s[4]+"Rs  | Address."+"]");
            
            }   
            line = br.readLine(); 
        }
        System.out.println("*Total Ordered Products - "+c);
    }
    public void viewAllOrders() throws IOException{
        System.out.println("-------------------------All Orders-------------------------------");
        int c = 0;
        BufferedReader br = File.readOrders();
        String line = br.readLine();
        while (line != null) {
            String []s=line.split("/");
            System.out.println("[ "+s[0]+" -> Id."+s[2]+" | "+s[3]+" | Price."+s[4]+"Rs | Address."+s[5]+" ]");
            line = br.readLine();
            c++; 
        }
        System.out.println("*Total Orders - "+c);

    }



}
