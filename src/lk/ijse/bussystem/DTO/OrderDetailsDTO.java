package lk.ijse.bussystem.DTO;

public class OrderDetailsDTO {
    private String pid;
    private String from;
    private String to;
    private double amount;
    private String bid;
    private String cusid;
    private String Seatid;
    private double seatprice;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String pid, String from, String to, double amount, String bid, String cusid,
                           String seatid, double seatprice) {
        this.pid = pid;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.bid = bid;
        this.cusid = cusid;
        this.Seatid = seatid;
        this.seatprice = seatprice;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getSeatid() {
        return Seatid;
    }

    public void setSeatid(String seatid) {
        Seatid = seatid;
    }

    public double getSeatprice() {
        return seatprice;
    }

    public void setSeatprice(double seatprice) {
        this.seatprice = seatprice;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "pid='" + pid + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", bid='" + bid + '\'' +
                ", cusid='" + cusid + '\'' +
                ", Seatid='" + Seatid + '\'' +
                ", seatprice=" + seatprice +
                '}';
    }
}
