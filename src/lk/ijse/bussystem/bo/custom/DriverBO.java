package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.DriverDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DriverBO {

    boolean SaveDriver(DriverDTO dto) throws SQLException, ClassNotFoundException;

    boolean UpdateDriver(DriverDTO dto) throws SQLException, ClassNotFoundException;

    DriverDTO SearchDriver(String id) throws SQLException, ClassNotFoundException;

    boolean deleteDriver(String id) throws SQLException, ClassNotFoundException;

    ResultSet getAllDriver() throws SQLException, ClassNotFoundException;
}
