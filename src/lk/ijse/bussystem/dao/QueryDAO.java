package lk.ijse.bussystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public interface QueryDAO extends SuperDAO{
    ResultSet getSeatPrice(String id) throws SQLException, ClassNotFoundException;
    ResultSet getAll(String id, String from, String to, LocalTime time) throws SQLException, ClassNotFoundException;


}
