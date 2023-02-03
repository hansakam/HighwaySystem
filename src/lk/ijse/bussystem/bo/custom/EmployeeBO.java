package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.EmployeeDTO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeBO {
     boolean SaveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
     boolean UpdateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
     EmployeeDTO SearchEmployee(String id) throws SQLException, ClassNotFoundException;
     boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
     ResultSet getAllEmployee() throws SQLException, ClassNotFoundException;
}
