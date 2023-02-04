package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.ScheduleDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public interface ScheduleDAO extends CrudDAO<ScheduleDTO,String> {
    ResultSet getAllToLocation() throws SQLException, ClassNotFoundException;
    ResultSet getAllFromLocation() throws SQLException, ClassNotFoundException;
    ResultSet getall() throws SQLException, ClassNotFoundException;
    ResultSet getSrarch(String id) throws SQLException, ClassNotFoundException;
    ResultSet getalltable(String id) throws SQLException, ClassNotFoundException;
    ResultSet getIds() throws SQLException, ClassNotFoundException;
    boolean schedulExsist(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException;
}
