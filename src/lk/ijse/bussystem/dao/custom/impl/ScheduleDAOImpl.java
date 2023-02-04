package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.ScheduleDTO;
import lk.ijse.bussystem.dao.custom.ScheduleDAO;
import lk.ijse.bussystem.entity.ScheduleEntity;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean Save(ScheduleEntity scheduleEntity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Schedule VALUES (?,?,?,?,?)",
                scheduleEntity.getBus_Id(),
                scheduleEntity.getTime(),
                scheduleEntity.getFrom(),
                scheduleEntity.getTo(),
                scheduleEntity.getSchedule_id()
        );
    }

    @Override
    public boolean Update(ScheduleEntity scheduleEntity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Schedule SET time=?,`from`=?,`to`=? WHERE Bus_Id=?",
                scheduleEntity.getTime(),
                scheduleEntity.getFrom(),
                scheduleEntity.getTo(),
                scheduleEntity.getBus_Id()

                );
    }

    @Override
    public ScheduleEntity  Search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE  from Schedule WHERE schedule_id=?",id);
    }

    @Override
    public ResultSet getAllToLocation() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT DISTINCT `to` FROM Schedule");
    }

    @Override
    public ResultSet getAllFromLocation() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT DISTINCT `from` FROM Schedule") ;
    }

    @Override
    public ResultSet getall() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Schedule");
    }

    @Override
    public ResultSet getSrarch(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Schedule WHERE Bus_Id=?",id);
    }

    @Override
    public ResultSet getalltable(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Schedule WHERE schedule_id=?",id);
    }

    @Override/** this is a join query */
    public ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Schedule.schedule_id from schedule order by length(schedule_id),schedule_id");
    }
    public boolean schedulExsist(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException {
        ResultSet set=CrudUtil.execute("SELECT Schedule.schedule_id FROM schedule WHERE time=? AND `to`=? AND  `from`=?",time,to,from);
        return set.next();
    }

//    public static ResultSet getAllToLocation() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT DISTINCT `to` FROM Schedule");
//    }
//
//    public static ResultSet getAllFromLocation() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT DISTINCT `from` FROM Schedule") ;
//    }
//
//    public static ResultSet getall() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM Schedule");
//    }
/**  setSchedule change it save  */

//    public static boolean Save(ScheduleDTO schedule) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("INSERT INTO Schedule VALUES (?,?,?,?,?)",
//                schedule.getBusId(),
//                schedule.getTime(),
//                schedule.getFrom(),
//                schedule.getTo(),
//                schedule.getS_id()
//        );
//    }

//    public static boolean Update(ScheduleDTO schedule) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("UPDATE Schedule SET time=?,`from`=?,`to`=? WHERE Bus_Id=?",
//                schedule.getTime(),
//                schedule.getFrom(),
//                schedule.getTo(),
//                schedule.getBusId()
//
//                );
//    }
//
//    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("DELETE  from Schedule WHERE schedule_id=?",id);
//    }

//    public static ResultSet getSrarch(String id) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM Schedule WHERE Bus_Id=?",id);
//    }
/** table data */
//    public static ResultSet getalltable(String id) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM Schedule WHERE schedule_id=?",id);
//    }

   /** public static ResultSet getData(String valueOf) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT  schedule_id FROM schedule WHERE Bus_Id=?",valueOf);
    }
    */

/** this is a join query */

//    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
//       return CrudUtil.execute("SELECT Schedule.schedule_id from schedule order by length(schedule_id),schedule_id");
//    }
}
