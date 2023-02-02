package lk.ijse.bussystem.model;

import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.to.Customer;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    public static boolean Save(Customer customer) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("INSERT INTO customer VALUES (?,?,?,?)",
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getEmail()
        );
    }

    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Customer_Id FROM customer ORDER BY  Customer_Id DESC LIMIT 1");
    }

    public static Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM customer WHERE Customer_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {

            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            );
        }
        return null;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Customer WHERE Customer_Id='" + id + "'";
        return CrudUtil.execute(sql);

    }


    public static boolean Update(Customer customer) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("UPDATE Customer SET name=?,address=?,`E-mail`=? WHERE Customer_Id=?",
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getId());

    }
    //insert table mathod

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM customer");
    }

    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Customer_Id FROM customer ");
    }

    public static ResultSet getName(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Name FROM customer WHERE Customer_Id=?",id);
    }
}

