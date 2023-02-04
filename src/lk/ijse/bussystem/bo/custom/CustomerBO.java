package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.CustomerDTO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    boolean SaveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean UpdateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;
    CustomerDTO SearchCustomer(String id) throws SQLException, ClassNotFoundException;
    ResultSet getAllCustomer() throws SQLException, ClassNotFoundException;
    ResultSet getIdsCustomer() throws SQLException, ClassNotFoundException;
    ResultSet getNameCustomer(String id) throws SQLException, ClassNotFoundException;



}
