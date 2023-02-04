package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.PaymentDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.entity.PaymentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<PaymentEntity,String> {
    boolean setDetais(PaymentEntity paymentEntity) throws SQLException, ClassNotFoundException;
    boolean setPaymentData(PaymentEntity paymentEntity) throws SQLException, ClassNotFoundException;
   // boolean setPaymentData(PaymentDTO payment) throws SQLException, ClassNotFoundException;
    ResultSet getPaymentIds() throws SQLException, ClassNotFoundException;
    //boolean setDetais(PaymentDTO payment) throws SQLException, ClassNotFoundException;
   // boolean setPayment(PaymentDTO paymentDTO) throws SQLException;
}
