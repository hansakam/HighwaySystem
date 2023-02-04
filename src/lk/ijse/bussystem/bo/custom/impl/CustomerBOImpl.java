/**
 * @author :Hansaka Malshan
 * created 2/3/2023---11:59 AM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.CustomerDTO;
import lk.ijse.bussystem.bo.custom.CustomerBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.SuperDAO;
import lk.ijse.bussystem.dao.custom.CustomerDAO;
import lk.ijse.bussystem.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.bussystem.entity.CustomerEntity;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);
   // CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public  boolean SaveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {

        return customerDAO.Save(new CustomerEntity(customer.getId(),customer.getName(),customer.getAddress(),customer.getEmail()));
    }
    @Override
    public  boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public  boolean UpdateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.Update(new CustomerEntity(customer.getId(),customer.getName(),customer.getAddress(),customer.getEmail()));
    }
    @Override
    public CustomerDTO SearchCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerEntity search = customerDAO.Search(id);
        return new CustomerDTO(search.getCustomer_Id(),search.getName(),search.getAddress(),search.getE_mail());
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
