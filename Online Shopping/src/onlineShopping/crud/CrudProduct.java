package onlineShopping.crud;

import onlineShopping.bean.Product;
import onlineShopping.readWrite.ReadWrite;

import java.io.*;
import java.util.Scanner;

public class CrudProduct extends Product {
    static String mail,pass;
    Scanner sc=new Scanner(System.in);

    public static void loginInfo(String m,String p){
        mail=m;
        pass=p;
    }
    public void productList() throws IOException {
        int c = 0;
        System.out.println("-------------------Products for Sale--------------------");
        BufferedReader br=ReadWrite.readProduct();
        String read=br.readLine();
        if (read==null){
            System.out.println("-> Empty <-");
        }
        while (read != null){
            c++;
            String[] s=read.split("/");
                System.out.println(c+"-> "+s[4]+", "+s[2]+", Id-"+s[3]+", Price-"+s[5]+", Quantity-"+s[6]);
            read=br.readLine();
        }
        System.out.println();
    }

    public boolean productOperation() throws IOException {
        boolean l=false;
        System.out.println("-----------------Select the Desired option-----------------");
        System.out.println("1.Buy Product | 2.Sell Your Product | 3.View Specification");
        System.out.println("4.Remove Your Product | 5.View Your Products | 6.Exit");
        int s=sc.nextInt();
        switch (s){
            case 1:l=buyProduct();
            break;
            case 2:l=sellProduct();
            break;
            case 3:l=specification();
            break;
            case 5:l=viewList();
            break;
            default:break;
        }
        return l;
    }
    public boolean buyProduct() throws IOException {
        System.out.println("Enter Product Name");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Enter Product Id");
        String id=sc.nextLine();
        System.out.println("Enter Quantity");
        String q=sc.nextLine();

        BufferedReader b=ReadWrite.readProduct();
        String line=b.readLine();
        while (line != null){
            String[] s=line.split("/");
            if (name.equals(s[2]) && id.equals(s[3]) && q.equals(s[6])){
                System.out.println(q+" "+name+" "+id+" will be delivered at your home Soon");
                break;
            }
            line=b.readLine();
            if (line==null){
                System.out.println("-> Wrong Name, Id and Quantity of Product <-");
                System.out.println("-> Select Buy Option & Enter Valid Details <-\n");
                //productOperation();
            }
        }
        return true;
    }
    public boolean sellProduct() throws IOException {
        System.out.println("*-> If you do not enter valid info of your product then Admin will remove your Product <-*\n");
        System.out.println("Enter Product Name(Ex.CompanyName ModelName)");
        setName(sc.next());
        System.out.println("Enter Product Id");
        sc.next();
        setId(sc.nextInt());
        System.out.println("Enter Product Category");
        sc.nextLine();
        setCategory(sc.nextLine());
        System.out.println("Enter Product Price");
        setPrice(sc.nextFloat());
        System.out.println("Enter product Quantity");
        setQuantity(sc.nextInt());
        System.out.println("Enter All the Specifications of Your Product");
        sc.nextLine();
        setSpecs(sc.nextLine());

       ReadWrite.writeProduct(mail,pass,getName(),getId(),getCategory(),getPrice(),getQuantity(),getSpecs());
       System.out.println("*- Your Product Added to Home Page for Sale *-");
       //productOperation();
        return true;
    }
    public boolean specification() throws IOException {
        System.out.println("Enter Product Name");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Enter Product Id");
        String id=sc.nextLine();

        BufferedReader b=ReadWrite.readProduct();
        String line=b.readLine();
        while (line!=null){
            String[] s=line.split("/");
            if (name.equals(s[2]) && id.equals(s[3])){
                System.out.println(s[7]);
                break;
            }
            line=b.readLine();
            if (line==null){
                System.out.println("-> Wrong Name or Id of Product <-");
               // productOperation();
            }
        }
        return true;
    }

    public void removeProduct() throws IOException {
        System.out.println("Enter Product Name");
        String n= sc.nextLine();
        System.out.println("Enter Product Id");
        String i= sc.nextLine();
        System.out.println("Enter Product Category");
        String c= sc.nextLine();

        FileReader fw=new FileReader("C:\\Users\\Nikhil Tripathi\\Desktop\\Product.txt");
        BufferedReader br=new BufferedReader(fw);
        String read=br.readLine();
        while (read != null){
            String[] s=read.split("/");
            if (s[0].equals(mail) && s[1].equals(pass) && s[2].equals(n) && s[3].equals(i) && s[4].equals(c)) {
                System.out.println("-Product Removed-");
                break;
            }
            read=br.readLine();
        }
    }

    public boolean viewList() throws IOException {
        int c = 0;
        System.out.println("-List of Your Products Added to Home Page for Sale-");

        BufferedReader br=ReadWrite.readProduct();
        String read=br.readLine();
        while (read != null){
            c++;
            String[] s=read.split("/");
            if (s[0].equals(mail) && s[1].equals(pass)) {
                System.out.println(c+"-> "+s[4]+", "+s[2]+", Id-"+s[3]+", Price-"+s[5]+", Quantity-"+s[6]+", Specifications-"+s[7]);
            }
            read=br.readLine();
            if(!s[0].equals(mail) && !s[1].equals(pass)){
                System.out.println("-> Empty <-\n");
                //productOperation();
            }
        }
        return true;
    }
}
