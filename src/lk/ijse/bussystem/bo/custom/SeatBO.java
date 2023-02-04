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
    boolean setSeat(String price, Object id) throws SQLException, ClassNotFoundException;
    ResultSet getData(String id) throws SQLException, ClassNotFoundException;
    ResultSet getId() throws SQLException, ClassNotFoundException;
    boolean updateSeat(String price, String id) throws SQLException, ClassNotFoundException;
    ResultSet getAll() throws SQLException, ClassNotFoundException;
}
