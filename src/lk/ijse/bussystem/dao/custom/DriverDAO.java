package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.DriverDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.entity.DriverEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DriverDAO extends CrudDAO<DriverEntity,String> {
    ResultSet getAll() throws SQLException, ClassNotFoundException;
}
