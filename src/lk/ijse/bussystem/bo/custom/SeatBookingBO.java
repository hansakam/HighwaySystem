package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public interface SeatBookingBO extends SuperBO{
    boolean updateAllSeatBooking() throws SQLException, ClassNotFoundException;

    boolean updateStatusSeatBooking (String id, String status) throws SQLException, ClassNotFoundException;

    //public ResultSet getSeatPriceSeatBooking(String id) throws SQLException, ClassNotFoundException;

     //ResultSet getAllSeatBooking(String id, String from, String to, LocalTime time) throws SQLException, ClassNotFoundException;



}
