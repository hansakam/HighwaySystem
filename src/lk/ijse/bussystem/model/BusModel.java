package lk.ijse.bussystem.model;

import lk.ijse.bussystem.to.Bus;
import lk.ijse.bussystem.to.Driver;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusModel {

    public static boolean Add(Bus bus) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO BUS VALUES(?,?,?,?,?)",
                bus.getId(),
                bus.getCapasity(),
                bus.getBusnumber(),
                bus.getSeatid(),
                bus.getSeat()

        );
    }

    public static boolean Update(Bus bus) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE BUS SET Capasity=?, Bus_Number=? WHERE Bus_Id=?",
                bus.getCapasity(),
                bus.getBusnumber(),
                bus.getId(),
                bus.getSeat(),
                bus.getSeatid()
        );
    }

    public static Bus Search(String sid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Bus WHERE  Bus_Id = ?";
        ResultSet result = CrudUtil.execute(sql, sid);
        if (result.next()) {

            return new Bus(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)




            );
        }
        return null;
    }


    public static ResultSet search(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Seat_Id FROM booking WHERE Bus_Id=?",
                id
        );
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *FROM BUS");
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM bus WHERE Bus_Id ='" + id + "'";
        return CrudUtil.execute(sql);

    }

    public static ResultSet getSeatcount(String bus_id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT seatCount FROM bus WHERE Bus_Id=?",bus_id);
    }

    public static ResultSet getBusNumber(String bus_id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Bus_Number FROM bus WHERE Bus_Id=?",bus_id);
    }

    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT bus_id FROM bus");
    }
}
