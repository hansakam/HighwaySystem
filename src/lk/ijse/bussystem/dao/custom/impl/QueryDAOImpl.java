/**
 * @author :Hansaka Malshan
 * created 2/3/2023---12:56 AM
 */
package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.dao.QueryDAO;
import lk.ijse.bussystem.util.CrudUtil;
import java.time.LocalTime;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QueryDAOImpl implements QueryDAO {
    @Override
    public ResultSet getSeatPrice(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT s.Seat_Price FROM bus b INNER JOIN seat s ON b.seat_id=s.Seat_Id WHERE b.Bus_Id=?",id);
    }

    @Override
    public ResultSet getAll(String id, String from, String to, LocalTime time) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT b.booking_seat_id,b.bus_id,b.status FROM seat_booking b INNER JOIN schedule s ON b.schedule_id=s.schedule_id WHERE b.schedule_id=? AND s.`from`=?AND s.`to`=? AND s.time=?",id,from,to,time);
    }
}
