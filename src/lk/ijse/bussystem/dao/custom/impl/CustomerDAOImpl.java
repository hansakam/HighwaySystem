package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.CustomerDTO;
import lk.ijse.bussystem.dao.custom.CustomerDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

   @Override
    public  boolean Save(CustomerDTO customer) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("INSERT INTO customer VALUES (?,?,?,?)",
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getEmail()
        );
    }

/**    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Customer_Id FROM customer ORDER BY  Customer_Id DESC LIMIT 1");
    }
*/
   @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Customer WHERE Customer_Id='" + id + "'";
        return CrudUtil.execute(sql);

    }

    @Override
    public  boolean Update(CustomerDTO customer) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("UPDATE Customer SET name=?,address=?,`E-mail`=? WHERE Customer_Id=?",
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getId());

    }

    @Override
    public CustomerDTO Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM customer WHERE Customer_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {

            return new CustomerDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            );
        }
        return null;
    }
    //insert table mathod
    @Override
    public  ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM customer");
    }
    @Override
    public  ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Customer_Id FROM customer ");
    }
    @Override
    public  ResultSet getName(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Name FROM customer WHERE Customer_Id=?",id);
    }
}

