package onlineShopping.bean;

public class Product {
    private int id;
    private String name;
    private float price;
    private String category;
    private int quantity;
    private String specs;

    public String getSpecs() {return specs;}
    public void setSpecs(String specs) {this.specs = specs;}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
