package onlineShopping.readWrite;

import java.io.*;

public class ReadWrite {
    public static void writeProduct(String m,String p,String name,int id,String category,float price,int quantity,String sp) throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\Nikhil Tripathi\\Desktop\\Product.txt",true);
        BufferedWriter w=new BufferedWriter(fw);
        w.write(m+"/"+p+"/"+name+"/"+id+"/"+category+"/"+price+"/"+quantity+"/"+sp);
        w.newLine();
        w.flush();
    }
    public static void writeUser(String n,String m,String e,String p) throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\Nikhil Tripathi\\Desktop\\User.txt",true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write(n+"/"+m+"/"+e+"/"+p);
        w.newLine();
        w.flush();
    }
    public static void writeAdmin(String n,String m,String e,String p) throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\Nikhil Tripathi\\Desktop\\User.txt",true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write("Admin/"+n+"/"+m+"/"+e+"/"+p);
        w.newLine();
        w.flush();
    }
    public static BufferedReader readUser() throws FileNotFoundException {
        FileReader fw=new FileReader("C:\\Users\\Nikhil Tripathi\\Desktop\\User.txt");
        return new BufferedReader(fw);
    }
    public static BufferedReader readProduct() throws FileNotFoundException {
        FileReader fw=new FileReader("C:\\Users\\Nikhil Tripathi\\Desktop\\Product.txt");
        return new BufferedReader(fw);
    }
}
