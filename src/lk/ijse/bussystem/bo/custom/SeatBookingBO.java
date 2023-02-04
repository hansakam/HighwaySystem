package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.util.CrudUtil;

import java.sql.SQLException;

public interface SeatBookingBO extends SuperBO{
    boolean updateAllSeatBooking() throws SQLException, ClassNotFoundException;

    boolean updateStatusSeatBooking (String id, String status) throws SQLException, ClassNotFoundException;

}
