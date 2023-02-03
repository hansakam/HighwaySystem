package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.ScheduleDTO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ScheduleBO {
    public boolean SaveSchedule(ScheduleDTO dto) throws SQLException, ClassNotFoundException;

    public boolean UpdateSchedule(ScheduleDTO dto) throws SQLException, ClassNotFoundException;

    public ScheduleDTO SearchSchedule(String s) throws SQLException, ClassNotFoundException;

    public boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException;

    public ResultSet getAllToLocationSchedule() throws SQLException, ClassNotFoundException;

    public ResultSet getAllFromLocationSchedule() throws SQLException, ClassNotFoundException;

    public ResultSet getallSchedule() throws SQLException, ClassNotFoundException;

    public ResultSet getSrarchSchedule(String id) throws SQLException, ClassNotFoundException;

    public ResultSet getalltableSchedule(String id) throws SQLException, ClassNotFoundException;

    public ResultSet getIdsSchedule() throws SQLException, ClassNotFoundException;
}
