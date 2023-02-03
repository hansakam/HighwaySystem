package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.BusDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BusBO {

    boolean SaveBUS(BusDTO dto) throws SQLException, ClassNotFoundException;

    boolean UpdateBUS(BusDTO dto) throws SQLException, ClassNotFoundException;

    BusDTO SearchBUS(String id) throws SQLException, ClassNotFoundException;

    boolean deleteBUS(String id) throws SQLException, ClassNotFoundException;

    ResultSet getAllBUS() throws SQLException, ClassNotFoundException;

    ResultSet getBusNumber(String bus_id) throws SQLException, ClassNotFoundException;

    ResultSet getIdsBUS() throws SQLException, ClassNotFoundException;


}
