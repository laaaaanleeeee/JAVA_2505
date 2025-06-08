package contructor;

public class OrderData {
    private int id;

    private String address;

    private String cusName;

    // hàm khởi tạo không tham số
//    public OrderData() {
//        System.out.println("Hàm khởi tạo không tham số đã được chạy");
//    }

    // hàm khởi tạo có tham số

    public OrderData(int id, String address, String cusName) {
        System.out.println("Hàm khởi tạo có tham số đã được chạy");
        this.id = id;
        this.address = address;
        this.cusName = cusName;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCusName() {
        return cusName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}
