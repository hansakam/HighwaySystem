package lk.ijse.bussystem.to;

import java.util.Date;
import java.util.Timer;

public class Bill {

    private String bill_id;
    private String Payment_id;
    private String Description;
    private double No_of_Passenger;
    private double Amount;
    private String Date;
    private String Time;
    private String cusId;

    public Bill() {
    }

    public Bill(String bill_id, String payment_id, String description, double no_of_Passenger, double amount, String date, String time, String cusId) {
        this.bill_id = bill_id;
        this.Payment_id = payment_id;
        this.Description = description;
        this.No_of_Passenger = no_of_Passenger;
        this.Amount = amount;
        this.Date = date;
        this.Time = time;
        this.cusId = cusId;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getPayment_id() {
        return Payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.Payment_id = payment_id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public double getNo_of_Passenger() {
        return No_of_Passenger;
    }

    public void setNo_of_Passenger(double no_of_Passenger) {
        this.No_of_Passenger = no_of_Passenger;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        this.Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_id='" + bill_id + '\'' +
                ", Payment_id='" + Payment_id + '\'' +
                ", Description='" + Description + '\'' +
                ", No_of_Passenger=" + No_of_Passenger +
                ", Amount=" + Amount +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
