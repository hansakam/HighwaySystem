package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public interface QueryBO extends SuperBO{
    ResultSet getSeatPrice(String id) throws SQLException, ClassNotFoundException;

    ResultSet getAll(String id, String from, String to, LocalTime time) throws SQLException, ClassNotFoundException;


}
