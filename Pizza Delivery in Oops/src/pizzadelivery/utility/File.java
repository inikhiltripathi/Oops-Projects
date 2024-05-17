package pizzadelivery.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

    public static void writeProduct(int id, String name, int mrp, int d, int p, String details) throws IOException {
        FileWriter fw = new FileWriter("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\Product.txt", true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write(id + "/" + name + "/" + mrp + "/" + d + "/" + p + "/" + details);
        w.newLine();
        w.flush();
        w.close();
    }

    public static void writeUser(String n, String m, String e, String p) throws IOException {
        FileWriter fw = new FileWriter("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\User.txt", true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write(n + "/" + m + "/" + e + "/" + p);
        w.newLine();
        w.flush();
        w.close();
    }

    public static void writeAdmin(String n, String m, String e, String p) throws IOException {
        FileWriter fw = new FileWriter("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\User.txt", true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write("Admin/" + n + "/" + m + "/" + e + "/" + p);
        w.newLine();
        w.flush();
        w.close();
    }

    public static BufferedReader readUser() throws FileNotFoundException {
        FileReader fw = new FileReader("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\User.txt");
        return new BufferedReader(fw);
    }

    public static BufferedReader readProduct() throws FileNotFoundException {
        FileReader fw = new FileReader("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\Product.txt");
        return new BufferedReader(fw);
    }

    public static void writeCart(String mail, String pass, int id, String name, int p) throws IOException {
        FileWriter fw = new FileWriter("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\Cart.txt", true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write(mail + "/" + pass + "/" + id + "/" + name + "/" + p);
        w.newLine();
        w.flush();
        w.close();
    }

    public static void writeOrder(String mail, String pass, int id, String name, int p, String add) throws IOException {
        FileWriter fw = new FileWriter("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\Order.txt", true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write(mail + "/" + pass + "/" + id + "/" + name + "/" + p + "/" + add);
        w.newLine();
        w.flush();
        w.close();
    }

    public static BufferedReader readCart() throws FileNotFoundException {
        FileReader fw = new FileReader("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\Cart.txt");
        return new BufferedReader(fw);
    }
    public static BufferedReader readOrders() throws FileNotFoundException {
        FileReader fw = new FileReader("D:\\Java Projects\\Pizza Delivery in Oops\\resource\\Order.txt");
        return new BufferedReader(fw);
    }

}
