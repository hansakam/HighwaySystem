package lk.ijse.bussystem.DTO;

public class PaymentDTO {
    private String Payment_Id;
    private String From;
    private String To;
    private String amount;
    private String Bus_Id;
    private String Customer_Id;
    private String date;
    private String time;

    public PaymentDTO() {
    }

    public PaymentDTO(String payment_Id, String from, String to, String amount, String bus_Id, String customer_Id, String date, String time) {
        Payment_Id = payment_Id;
        From = from;
        To = to;
        this.amount = amount;
        Bus_Id = bus_Id;
        Customer_Id = customer_Id;
        this.date = date;
        this.time = time;
    }


    public String getPayment_Id() {
        return Payment_Id;
    }

    public void setPayment_Id(String payment_Id) {
        Payment_Id = payment_Id;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBus_Id() {
        return Bus_Id;
    }

    public void setBus_Id(String bus_Id) {
        Bus_Id = bus_Id;
    }

    public String getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        Customer_Id = customer_Id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Payment{" +
                "Payment_Id='" + Payment_Id + '\'' +
                ", From='" + From + '\'' +
                ", To='" + To + '\'' +
                ", amount='" + amount + '\'' +
                ", Bus_Id='" + Bus_Id + '\'' +
                ", Customer_Id='" + Customer_Id + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}
