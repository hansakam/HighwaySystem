/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:31 PM
 */
package lk.ijse.bussystem.entity;

public class seat_booking {
    private String booking_seat_id;
    private String bus_id;
    private String status ;
    private String schedule_id;

    public seat_booking(String booking_seat_id, String bus_id, String status, String schedule_id) {
        this.booking_seat_id = booking_seat_id;
        this.bus_id = bus_id;
        this.status = status;
        this.schedule_id = schedule_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }
}
