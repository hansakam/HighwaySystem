/**
 * @author :Hansaka Malshan
 * created 2/3/2023---11:59 AM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.CustomerDTO;
import lk.ijse.bussystem.bo.custom.CustomerBO;
import lk.ijse.bussystem.dao.custom.CustomerDAO;
import lk.ijse.bussystem.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public  boolean SaveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.Save(customer);
    }
    @Override
    public  boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public  boolean UpdateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.Update(customer);
    }
    @Override
    public CustomerDTO SearchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.Search(id);
    }
    @Override
    public  ResultSet getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }
    @Override
    public  ResultSet getIdsCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getIds();
    }
    @Override
    public  ResultSet getNameCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getName(id);
    }


}
