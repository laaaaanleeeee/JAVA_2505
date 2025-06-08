package contructor;

public class Product {
    private int id;
    private String proName;
    private double price;
    private String country;

    public Product() {
    }

    public Product(int id, String proName, double price, String country) {
        this.id = id;
        this.proName = proName;
        this.price = price;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }
}
