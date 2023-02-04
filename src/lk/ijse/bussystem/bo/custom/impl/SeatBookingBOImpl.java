/**
 * @author :Hansaka Malshan
 * created 2/4/2023---9:45 AM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.bo.custom.SeatBookingBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.SuperDAO;
import lk.ijse.bussystem.dao.custom.SeatBookingDAO;
import lk.ijse.bussystem.dao.custom.impl.SeatBookingDAOImpl;

import java.sql.SQLException;

public class SeatBookingBOImpl implements SeatBookingBO {

    //SeatBookingDAO seatBookingDAO = new SeatBookingDAOImpl();
    SeatBookingDAO seatBookingDAO= (SeatBookingDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SEATBOOKING);
    @Override
    public boolean updateAllSeatBooking() throws SQLException, ClassNotFoundException {
        return seatBookingDAO.updateAll();

    }

    @Override
    public boolean updateStatusSeatBooking(String id, String status) throws SQLException, ClassNotFoundException {
        return seatBookingDAO.updateStatus(id,status);
    }

    /*public boolean updateStatusSeatBooking(String id, String status) throws SQLException, ClassNotFoundException {
        return seatBookingDAO.updateStatus(id,status);
    }*/
}
