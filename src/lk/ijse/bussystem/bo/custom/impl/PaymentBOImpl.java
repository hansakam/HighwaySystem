/**
 * @author :Hansaka Malshan
 * created 2/4/2023---12:03 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.PaymentDTO;
import lk.ijse.bussystem.bo.custom.PaymentBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.SuperDAO;
import lk.ijse.bussystem.dao.custom.PaymentDAO;
import lk.ijse.bussystem.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public boolean setPayment(PaymentDTO payment) throws SQLException {

        Connection connection = null;
            try {
                connection = DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);
                if (paymentDAO.setPaymentData(payment)) {
                    if (paymentDAO.setDetais(payment)) {
                        connection.commit();
                        return true;
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
            return false;

    }

    @Override
    public ResultSet getPaymentIds() throws SQLException, ClassNotFoundException {
        return paymentDAO.getPaymentIds();
    }
}
