/**
 * @author :Hansaka Malshan
 * created 2/4/2023---10:14 AM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.bo.custom.SeatBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.SuperDAO;
import lk.ijse.bussystem.dao.custom.SeatDAO;
import lk.ijse.bussystem.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class SeatBOImpl implements SeatBO {

   private final SeatDAO seatDAO = (SeatDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SEAT);

    @Override
    public boolean seatadded(LocalTime time, String from, String to) throws SQLException {

        System.out.println("on seat add method");
            Connection connection=null;
            try {
                connection= DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);
//                ResultSet set= getScgedulData(time,from,to);
                ResultSet set = seatDAO.getScgedulData(time, from, to);
                if (set.next()){
                    System.out.println(" Schedule id " +set.getString(1));
                    System.out.println(" Bus id " +set.getString(2));
                    if (seatDAO.setSeats(set.getString(1),set.getString(2))){
                        System.out.println("commit");
                        connection.commit();
                        return true;
                    }else {
                        System.out.println("roll back");
                        connection.rollback();
                    }
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }finally {
                connection.setAutoCommit(true);
            }
            System.out.println("return false ");
            return false;
        }

    @Override
    public boolean seatExsist(String id) throws SQLException, ClassNotFoundException {
        return seatDAO.seatExsist(id);
    }

    @Override
    public boolean setSeat(String price, Object id) throws SQLException, ClassNotFoundException {
        return seatDAO.setSeat(price,id);
    }

    @Override
    public ResultSet getData(String id) throws SQLException, ClassNotFoundException {
        return seatDAO.getData(id);
    }

    @Override
    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return seatDAO.getId();
    }

    @Override
    public boolean updateSeat(String price, String id) throws SQLException, ClassNotFoundException {
        return seatDAO.updateSeat(price,id);
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return seatDAO.getAll();
    }


}

