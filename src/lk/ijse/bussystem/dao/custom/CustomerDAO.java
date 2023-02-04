package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.CustomerDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.entity.CustomerEntity;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<CustomerEntity,String> {

     ResultSet getAll() throws SQLException, ClassNotFoundException;
     ResultSet getIds() throws SQLException, ClassNotFoundException;

    ResultSet getName(String id) throws SQLException, ClassNotFoundException;

}
