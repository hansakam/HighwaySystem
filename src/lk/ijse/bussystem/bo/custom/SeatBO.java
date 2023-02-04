package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public interface SeatBO extends SuperBO {
    boolean seatadded(LocalTime time, String from, String to) throws SQLException;
    boolean seatExsist(String id) throws SQLException, ClassNotFoundException;


}
