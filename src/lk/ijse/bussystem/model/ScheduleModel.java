package lk.ijse.bussystem.model;

import lk.ijse.bussystem.to.Schedule;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleModel {
    public static ResultSet getAllToLocation() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT DISTINCT `to` FROM Schedule");
    }

    public static ResultSet getAllFromLocation() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT DISTINCT `from` FROM Schedule") ;
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Schedule");
    }

    public static boolean setSchedule(Schedule schedule) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Schedule VALUES (?,?,?,?,?)",
                schedule.getBusId(),
                schedule.getTime(),
                schedule.getFrom(),
                schedule.getTo(),
                schedule.getS_id()
        );
    }

    public static boolean updateSchedule(Schedule schedule) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Schedule SET time=?,`from`=?,`to`=? WHERE Bus_Id=?",
                schedule.getTime(),
                schedule.getFrom(),
                schedule.getTo(),
                schedule.getBusId()

                );
    }

    public static boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE  from Schedule WHERE schedule_id=?",id);
    }

    public static ResultSet getSrarch(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Schedule WHERE Bus_Id=?",id);
    }

    public static ResultSet getAll(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Schedule WHERE schedule_id=?",id);
    }

    public static ResultSet getData(String valueOf) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT  schedule_id FROM schedule WHERE Bus_Id=?",valueOf);
    }

    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("SELECT Schedule.schedule_id from schedule order by length(schedule_id),schedule_id");
    }
}
