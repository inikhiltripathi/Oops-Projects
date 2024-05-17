package pizzadelivery.user;

import java.io.IOException;
import java.util.Scanner;

import pizzadelivery.product.ProductService;
import pizzadelivery.utility.Verify;

public class Controller {

    private static Controller obj;
    private Controller(){}
    public static synchronized Controller getObj(){
        if (obj == null) {
            obj= new Controller();
        }
        return obj;
    }
    
    public void user() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("- 1.Login | 2.Register | 3.Admin | 4.Exit -");
        int k = sc.nextInt();
        switch (k) {
            case 1 -> UserService.getObj().login(false);
            case 2 -> {
                UserService.getObj().register(false);
                ProductService.getObj().productList();
                UserService.getObj().userOperation();
            }    
            case 3 -> admin();
            case 4 -> System.out.println("ThankYou and Visit Again");
            default -> {
                System.out.println("*Invalid Option Select the Option Again");
                user();
            }
        }
        sc.close();
    }

    public void admin() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println("1.Login | 2.Register | 3.Back");
        int k = sc.nextInt();
        if (k == 2 && Verify.admin()) {
            System.out.println("Only Existing Admin can create new Admin");
            admin();
        }
        switch (k) {
            case 1 -> UserService.getObj().login(true);
            case 2 -> UserService.getObj().register(true);
            case 3 -> user();
            default -> {
                System.out.println("*Invalid Option Select the Option Again");
                admin();
            }
        }
        sc.close();
    }

}
