package pizzadelivery.product;

import java.util.Random;

public class ProductBean {

    private int id;
    private String name;
    private int mrp;
    private int discount;
    private int finalprice;
    private String details;

    private static ProductBean obj;

    private ProductBean() {
    }

    public static synchronized ProductBean getObj() {
        if (obj == null) {
            obj = new ProductBean();
        }
        return obj;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        Random r=new Random();
        id = r.nextInt(10000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalprice() {
        return finalprice;
    }

    public void setFinalprice() {
        finalprice = mrp - mrp * discount / 100;
        // this.finalprice = finalprice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static void setObj(ProductBean obj) {
        ProductBean.obj = obj;
    }

    // public String write() {
    //     try {
    //         File.writeProduct(id, name, mrp, discount, finalprice, details);
    //         return "Product Added Successfully";
    //     } catch (IOException e) {
    //         //System.out.println("Error "+e);
    //         return "Error in writing file";
    //     }
    // }
}
