/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:27 PM
 */
package lk.ijse.bussystem.entity;

import java.sql.Time;
import java.util.Date;

public class BillEntity {
    private String Bill_Id;
    private String Payment_Id;
    private String Description;
    private double Num_Of_Passenger;
    private double Amount_Paid;
    private Date Date;
    private Time Time;
    private String Customer_Id;

    public BillEntity(String bill_Id, String payment_Id, String description, double num_Of_Passenger, double amount_Paid, java.util.Date date, java.sql.Time time, String customer_Id) {
        this.Bill_Id = bill_Id;
        this.Payment_Id = payment_Id;
        this.Description = description;
        this.Num_Of_Passenger = num_Of_Passenger;
        this.Amount_Paid = amount_Paid;
        this.Date = date;
        this.Time = time;
        this.Customer_Id = customer_Id;
    }

    public String getBill_Id() {
        return Bill_Id;
    }

    public void setBill_Id(String bill_Id) {
        Bill_Id = bill_Id;
    }

    public String getPayment_Id() {
        return Payment_Id;
    }

    public void setPayment_Id(String payment_Id) {
        Payment_Id = payment_Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getNum_Of_Passenger() {
        return Num_Of_Passenger;
    }

    public void setNum_Of_Passenger(double num_Of_Passenger) {
        Num_Of_Passenger = num_Of_Passenger;
    }

    public double getAmount_Paid() {
        return Amount_Paid;
    }

    public void setAmount_Paid(double amount_Paid) {
        Amount_Paid = amount_Paid;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public void setTime(java.sql.Time time) {
        Time = time;
    }

    public String getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        Customer_Id = customer_Id;
    }
}
