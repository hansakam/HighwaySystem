/**
 * @author :Hansaka Malshan
 * created 2/3/2023---2:57 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.ScheduleDTO;
import lk.ijse.bussystem.bo.custom.ScheduleBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.SuperDAO;
import lk.ijse.bussystem.dao.custom.ScheduleDAO;
import lk.ijse.bussystem.dao.custom.impl.ScheduleDAOImpl;
import lk.ijse.bussystem.entity.ScheduleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class ScheduleBOImpl implements ScheduleBO {

    //  ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    private final ScheduleDAO scheduleDAO = (ScheduleDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SCHEDULE);

    @Override
    public boolean SaveSchedule(ScheduleDTO dto) throws SQLException, ClassNotFoundException {
        return scheduleDAO.Save(new ScheduleEntity(dto.getS_id(),dto.getTime(),dto.getFrom(),dto.getTo(),dto.getS_id()));

    }

    @Override
    public boolean UpdateSchedule(ScheduleDTO dto) throws SQLException, ClassNotFoundException {
        return scheduleDAO.Update(new ScheduleEntity(dto.getS_id(),dto.getTime(),dto.getFrom(),dto.getTo(),dto.getS_id()));
    }

    @Override
    public ScheduleDTO SearchSchedule(String id) throws SQLException, ClassNotFoundException {
        ScheduleEntity search = scheduleDAO.Search(id);
        return new ScheduleDTO(search.getSchedule_id(),search.getFrom(),search.getTo(),search.getBus_Id(),search.getBus_Id());
    }

    @Override
    public boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException {
        return scheduleDAO.delete(id);
    }

    @Override
    public ResultSet getAllToLocationSchedule() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getAllToLocation();
    }

    @Override
    public ResultSet getAllFromLocationSchedule() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getAllFromLocation();
    }

    @Override
    public ResultSet getallSchedule() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getall();
    }

    @Override
    public ResultSet getSrarchSchedule(String id) throws SQLException, ClassNotFoundException {
        return scheduleDAO.getSrarch(id);
    }

    @Override
    public ResultSet getalltableSchedule(String id) throws SQLException, ClassNotFoundException {
        return scheduleDAO.getalltable(id);
    }

    @Override
    public ResultSet getIdsSchedule() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getIds();
    }

    @Override
    public boolean schedulExsist(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException {
        return scheduleDAO.schedulExsist(time,from,to);

    }

}
