/**
 * @author :Hansaka Malshan
 * created 2/3/2023---2:28 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.EmployeeDTO;
import lk.ijse.bussystem.bo.custom.EmployeeBO;
import lk.ijse.bussystem.dao.custom.EmployeeDAO;
import lk.ijse.bussystem.dao.custom.impl.EmployeeDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public boolean SaveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.Save(dto);
    }

    @Override
    public boolean UpdateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.Update(dto);
    }

    @Override
    public EmployeeDTO SearchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.Search(id);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public ResultSet getAllEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAll();
    }
}
