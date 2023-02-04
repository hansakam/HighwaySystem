package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.SeatDTO;
import lk.ijse.bussystem.dao.CrudDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public interface SeatDAO extends CrudDAO<SeatDTO,String> {
    boolean seatExsist(String id) throws SQLException, ClassNotFoundException;
   // boolean schedulExsist(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException;
    ResultSet getScgedulData(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException;
    int getSeatCount(String bus_id) throws SQLException, ClassNotFoundException;
    boolean setSeats(String S_id, String bus_id) throws SQLException, ClassNotFoundException;
    ResultSet getData(String id) throws SQLException, ClassNotFoundException;
    boolean updateSeat(String price, String id) throws SQLException, ClassNotFoundException;
    boolean setSeat(String price, Object id) throws SQLException, ClassNotFoundException;
    ResultSet getId() throws SQLException, ClassNotFoundException;
    ResultSet getAll() throws SQLException, ClassNotFoundException;
    //boolean seatadded(LocalTime time, String from, String to) throws SQLException;
}
