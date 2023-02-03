package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.DriverDTO;
import lk.ijse.bussystem.dao.CrudDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DriverDAO extends CrudDAO<DriverDTO,String> {
    ResultSet getAll() throws SQLException, ClassNotFoundException;
}
