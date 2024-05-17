import java.util.Scanner;

public class Atm {
    String name;
    int age;int no;int pin;
    float balance=1000;
    Scanner sc=new Scanner(System.in);

    void display(){
        System.out.println("--Select option--");
        System.out.println("1.Create Account | 2.Login | 3.Exit");
        int a= sc.nextInt();
        switch (a){
            case 1 : process();break;
            case 2 : login();break;
            case 3 :
                System.out.println("Thank You");break;
            default:
                System.out.println("Invalid Option");
                display();
        }
    }

    void process(){
        System.out.println("--Enter Your Details--");
        System.out.println("Name : ");
        name= sc.nextLine();
        sc.nextLine();
        System.out.println("Age : ");
        age=sc.nextInt();
        System.out.println("Mobile No. : ");
        no=sc.nextInt();
        System.out.println("Create pin : ");
        pin=sc.nextInt();
        System.out.println("--Account Created Successfully--");
        login1();
    }
    void login1(){
        System.out.print("Enter Your PIN : ");
        int b1= sc.nextInt();
        System.out.println();
        if (b1==pin){
            display1();
        }else{
            System.out.println("Wrong PIN");
            login1();
        }
    }
    void login(){
        System.out.print("Enter Your Pin : ");
        int b= sc.nextInt();
        if (b==12345){
            display1();
        }else {
            System.out.println("Wrong PIN");
            display();
        }
    }
    void display1(){
        System.out.println("--Select Option--");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        process1();
    }
    void process1(){
        int p1= sc.nextInt();
        switch (p1){
            case 1 :
                System.out.println("Balance : "+balance);
                m();break;
            case 2 :
                System.out.print("Enter the Amount : ");
                float f= sc.nextFloat();
                System.out.println();
                balance=balance+f;
                System.out.println("Deposit of "+f+" Successful");
                m();break;
            case 3 :
                System.out.print("Enter the Amount : ");
                float f1= sc.nextFloat();
                System.out.println();
                if (f1<=balance){
                    balance=balance-f1;
                    System.out.println("Withdrawal of "+f1+" Successful");
                    m();
                }else{
                    System.out.println("Insufficient Balance");
                    m();
                }
            case 4 :
                System.out.println("Thank You");break;
            default:
                System.out.println("Invalid Option");
        }
    }
    void m(){
        System.out.println("1.Back | 2.Exit");
        int m=sc.nextInt();
        switch (m){
            case 1 :display1();break;
            case 2:System.out.println("Thank You");break;
            default:
                System.out.println("Invalid Option");
        }
    }

    public static void main(String[] args) {
        Atm r=new Atm();
        r.display();
    }

}
