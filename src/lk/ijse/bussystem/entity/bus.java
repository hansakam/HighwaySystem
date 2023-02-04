/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:27 PM
 */
package lk.ijse.bussystem.entity;

public class bus {
    private String Bus_Id;
    private String Capasity;
    private String Bus_Number;
    private String seat_id;
    private int seatCount;

    public bus(String bus_Id, String capasity, String bus_Number, String seat_id, int seatCount) {
        this.Bus_Id = bus_Id;
        this.Capasity = capasity;
        this.Bus_Number = bus_Number;
        this.seat_id = seat_id;
        this.seatCount = seatCount;
    }

    public String getBus_Id() {
        return Bus_Id;
    }

    public void setBus_Id(String bus_Id) {
        Bus_Id = bus_Id;
    }

    public String getCapasity() {
        return Capasity;
    }

    public void setCapasity(String capasity) {
        Capasity = capasity;
    }

    public String getBus_Number() {
        return Bus_Number;
    }

    public void setBus_Number(String bus_Number) {
        Bus_Number = bus_Number;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
