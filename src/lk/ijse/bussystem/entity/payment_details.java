/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:29 PM
 */
package lk.ijse.bussystem.entity;

public class payment_details {
    private String Payment_Id;
    private String booking_seat_id;
    private String bus_id;

    public payment_details(String payment_Id, String booking_seat_id, String bus_id) {
        this.Payment_Id = payment_Id;
        this.booking_seat_id = booking_seat_id;
        this.bus_id = bus_id;
    }

    public String getPayment_Id() {
        return Payment_Id;
    }

    public void setPayment_Id(String payment_Id) {
        Payment_Id = payment_Id;
    }

    public String getBooking_seat_id() {
        return booking_seat_id;
    }

    public void setBooking_seat_id(String booking_seat_id) {
        this.booking_seat_id = booking_seat_id;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }
}
