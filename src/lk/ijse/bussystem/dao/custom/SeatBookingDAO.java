package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.dao.SuperDAO;

import java.sql.SQLException;

//find
public interface SeatBookingDAO extends SuperDAO {
    boolean updateAll() throws SQLException, ClassNotFoundException;
    boolean updateStatus(String id, String status) throws SQLException, ClassNotFoundException;
}
