package onlineShopping.main;

import onlineShopping.crud.CrudAdmin;
import onlineShopping.crud.CrudProduct;
import onlineShopping.crud.CrudUser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("*-Welcome to Online Shopping-*");
        System.out.println("--Select the Desired Option--");
        System.out.println("  1.User | 2.Admin | 3.Exit");

        Scanner sc=new Scanner(System.in);
        CrudUser crudUser=new CrudUser();
        CrudAdmin crudAdmin=new CrudAdmin();
        CrudProduct crudProduct =new CrudProduct();
        boolean u=false,a=false,p=false,z=false;
        int n=0;

        int k= sc.nextInt();
        switch (k){
            case 1:u=crudUser.createUser();
            break;
            case 2:a=crudAdmin.show();
            break;
            default:break;
        }
        if (u){
            crudProduct.productList();
            p=crudProduct.productOperation();
        }
        while (p==true){
            p=crudProduct.productOperation();
            if (p==false){
                break;
            }
        }
        if (a){
            n=crudAdmin.adminOperation();
        }
        while (n!=0 || z){
            switch (n){
                case 1:z=crudProduct.buyProduct();
                break;
                case 2:z=crudProduct.sellProduct();
                break;
                case 3:z=crudProduct.viewList();
                break;
                case 4:z=crudAdmin.createAdmin();
                case 5:crudProduct.productList();
                z=true;
                break;
                default:break;
            }
           if (z){
               n=crudAdmin.adminOperation();
           }
        }
    }
}