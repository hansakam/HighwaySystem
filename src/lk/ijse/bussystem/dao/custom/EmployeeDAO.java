package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.EmployeeDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<EmployeeEntity,String> {
    ResultSet getAll() throws SQLException, ClassNotFoundException;
}
