/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:31 PM
 */
package lk.ijse.bussystem.entity;

public class seat {
    private String Seat_Id ;
    private String Seat_Price;

    public seat(String seat_Id, String seat_Price) {
        Seat_Id = seat_Id;
        Seat_Price = seat_Price;
    }

    public String getSeat_Id() {
        return Seat_Id;
    }

    public void setSeat_Id(String seat_Id) {
        Seat_Id = seat_Id;
    }

    public String getSeat_Price() {
        return Seat_Price;
    }

    public void setSeat_Price(String seat_Price) {
        Seat_Price = seat_Price;
    }
}
