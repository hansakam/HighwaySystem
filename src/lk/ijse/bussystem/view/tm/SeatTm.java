package lk.ijse.bussystem.view.tm;

public class SeatTm {
    private String id;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SeatTm{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
