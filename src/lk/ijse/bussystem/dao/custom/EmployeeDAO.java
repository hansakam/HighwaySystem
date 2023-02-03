package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.EmployeeDTO;
import lk.ijse.bussystem.dao.CrudDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<EmployeeDTO,String> {
    ResultSet getAll() throws SQLException, ClassNotFoundException;
}
