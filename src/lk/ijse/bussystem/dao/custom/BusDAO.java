package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.BusDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BusDAO extends CrudDAO<BusDTO,String> {
     ResultSet getBusNumber(String bus_id) throws SQLException, ClassNotFoundException;

     ResultSet getIds() throws SQLException, ClassNotFoundException;

     ResultSet getAll() throws SQLException, ClassNotFoundException;

}
