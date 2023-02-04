/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:29 PM
 */
package lk.ijse.bussystem.entity;

import java.sql.Date;
import java.sql.Time;

public class PaymentEntity {
    private String Payment_Id;
    private String From;
    private String To;
    private double amount;
    private String Bus_Id;
    private String Customer_Id;
    private String date;
    private String time;

    public PaymentEntity(String payment_Id, String from, String to, double amount, String bus_Id, String customer_Id, String date, String time) {
        this.Payment_Id = payment_Id;
        this.From = from;
        this.To = to;
        this.amount = amount;
        this.Bus_Id = bus_Id;
        this.Customer_Id = customer_Id;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
}
