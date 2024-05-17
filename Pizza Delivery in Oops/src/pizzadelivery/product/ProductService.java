package pizzadelivery.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import pizzadelivery.utility.File;


public class ProductService {

    ProductBean b = ProductBean.getObj();
    Scanner sc = new Scanner(System.in);
    private static ProductService obj;
    private ProductService(){}
    public static synchronized ProductService getObj(){
        if (obj == null) {
            obj = new ProductService();
        }
        return obj;
    }

    public void productList() throws IOException{
        System.out.println("--------------------------------------------------------------------------------------------------");
        BufferedReader br = File.readProduct();
        String line = br.readLine();
        while (line!=null) {    
            String []s= line.split("/");
            System.out.println("[Id."+s[0]+" | "+s[1]+" | Mrp."+s[2]+"Rs | Discount."+s[3]+"% | Price."+s[4]+"Rs | Details-"+s[5]+"]"); 
            line=br.readLine();
        }
        
    }
    public void addProduct(){
        System.out.println("-------------------------------\nEnter Product Name");
        b.setName(sc.nextLine());
        System.out.println("Enter MRP");
        b.setMrp(sc.nextInt());
        System.out.println("Enter Discount Percentage");
        b.setDiscount(sc.nextInt());
        System.out.println("Enter Product Details");
        sc.nextLine();
        b.setDetails(sc.nextLine());
        b.setFinalprice();
        b.setId();
        
        try {
            File.writeProduct(b.getId(), b.getName(), b.getMrp(), b.getDiscount(), b.getFinalprice(), b.getDetails());
            System.out.println("Product Added Successfully");
        } catch (IOException e) {
            System.out.println("Error in Writing File");
        }
    }
}
