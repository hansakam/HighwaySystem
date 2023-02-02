package lk.ijse.bussystem.model;

import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class SeatBookingModel {
    public static boolean updateStatus(String id, String status) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("UPDATE seat_booking SET status =? WHERE booking_seat_id=?",status,id);
    }

    public static boolean seatExist(String id) throws SQLException, ClassNotFoundException {
        ResultSet execute = CrudUtil.execute("SELECT * FROM seat_booking where bus_id=?", id);
        return execute.next();
    }

    public static void setSeat(int count ,String bus_id,String sch_id) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < count; i++) {
            CrudUtil.execute("INSERT INTO seat_booking VALUES(?,?,?,?)","S"+(i+1),bus_id,"Available",sch_id);
        }
    }

    public static ResultSet getAll(String id, String from, String to, LocalTime time) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT b.booking_seat_id,b.bus_id,b.status FROM seat_booking b INNER JOIN schedule s ON b.schedule_id=s.schedule_id WHERE b.schedule_id=? AND s.`from`=?AND s.`to`=? AND s.time=?",id,from,to,time);
    }

    public static ResultSet getSeatPrice(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT s.Seat_Price FROM bus b INNER JOIN seat s ON b.seat_id=s.Seat_Id WHERE b.Bus_Id=?",id);
    }

    public static boolean updateAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE seat_booking SET status=?","Available");
    }

    public static ResultSet getBusId(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT DISTINCT b.bus_id FROM seat_booking b INNER JOIN schedule s WHERE s.time =? AND s.`from`=? AND s.`to`=?",time,from,to);
    }
}
