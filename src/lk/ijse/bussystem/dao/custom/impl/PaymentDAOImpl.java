package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.controller.SheatbookingController;
import lk.ijse.bussystem.dao.custom.PaymentDAO;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.DTO.OrderDetailsDTO;
import lk.ijse.bussystem.DTO.PaymentDTO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {

    public static boolean Paymentd(OrderDetailsDTO orderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Payment VALUES (?,?,?,?,?,?)",
                orderDetails.getPid(),
                orderDetails.getFrom(),
                orderDetails.getTo(),
                orderDetails.getAmount(),
                orderDetails.getBid(),
                orderDetails.getCusid()
        );

    }

    /** public static ResultSet getIds() throws SQLException, ClassNotFoundException {
     return CrudUtil.execute("SELECT Customer_Id FROM customer");
     }
     */


    /**
     * Transaction
     */
    public  boolean setPayment(PaymentDTO payment) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (setPaymentData(payment)) {
                if (setDetais(payment)) {
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
    public boolean Save(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Update(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PaymentDTO Search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean setPaymentData(PaymentDTO payment) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?,?,?,?,?,?)",
                payment.getPayment_Id(),
                payment.getFrom(),
                payment.getTo(),
                payment.getAmount(),
                payment.getBus_Id(),
                payment.getCustomer_Id(),
                payment.getDate(),
                payment.getTime()
        );
    }

    @Override
    public ResultSet getPaymentIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Payment_Id FROM payment order by length(Payment_Id),Payment_Id ");
    }

    @Override
    public boolean setDetais(PaymentDTO payment) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < SheatbookingController.seat.size(); i++) {
            if (CrudUtil.execute("INSERT INTO payment_details VALUES (?,?,?)",
                    payment.getPayment_Id(),
                    SheatbookingController.seat.get(i),
                    payment.getBus_Id()
            )) {
            } else {
                return false;
            }

        }
        return true;
        }

//    private static boolean setDetais(PaymentDTO payment) throws SQLException, ClassNotFoundException {
//        for (int i = 0; i < SheatbookingController.seat.size(); i++) {
//            if (CrudUtil.execute("INSERT INTO payment_details VALUES (?,?,?)",
//                    payment.getPayment_Id(),
//                    SheatbookingController.seat.get(i),
//                    payment.getBus_Id()
//            )) {
//            } else {
//                return false;
//            }
//
//        }
//        return true;
//    }
//
//    private static boolean setPaymentData(PaymentDTO payment) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?,?,?,?,?,?)",
//                payment.getPayment_Id(),
//                payment.getFrom(),
//                payment.getTo(),
//                payment.getAmount(),
//                payment.getBus_Id(),
//                payment.getCustomer_Id(),
//                payment.getDate(),
//                payment.getTime()
//        );
//    }
//
//    public static ResultSet getPaymentIds() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT Payment_Id FROM payment order by length(Payment_Id),Payment_Id ");
//    }

    }

