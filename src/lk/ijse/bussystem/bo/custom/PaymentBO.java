package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.PaymentDTO;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentBO extends SuperBO{
    boolean setPayment(PaymentDTO payment) throws SQLException;
    ResultSet getPaymentIds() throws SQLException, ClassNotFoundException;
}
