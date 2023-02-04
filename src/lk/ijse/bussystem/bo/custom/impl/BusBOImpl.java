/**
 * @author :Hansaka Malshan
 * created 2/3/2023---12:01 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.BusDTO;
import lk.ijse.bussystem.bo.custom.BusBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.custom.BusDAO;
import lk.ijse.bussystem.entity.BusEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusBOImpl implements BusBO {

    BusDAO busDAO = (BusDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BUS);

    @Override
    public boolean SaveBUS(BusDTO dto) throws SQLException, ClassNotFoundException {

        return busDAO.Save(new BusEntity(dto.getId(),dto.getCapasity(),dto.getBusnumber(),dto.getSeatid(),dto.getSeat()));
    }
    @Override
    public boolean UpdateBUS(BusDTO dto) throws SQLException, ClassNotFoundException {
        return busDAO.Update(new BusEntity(dto.getId(),dto.getCapasity(),dto.getBusnumber(),dto.getSeatid(),dto.getSeat()));
    }
    @Override
    public BusDTO SearchBUS(String id) throws SQLException, ClassNotFoundException {
        BusEntity search = busDAO.Search(id);
        return new BusDTO(search.getBus_Id(),search.getCapasity(),search.getBus_Number(),search.getSeatCount(),search.getSeat_id());
    }
    @Override
    public boolean deleteBUS(String id) throws SQLException, ClassNotFoundException {
     return busDAO.delete(id);
    }
    @Override
    public ResultSet getAllBUS() throws SQLException, ClassNotFoundException {
        return busDAO.getAll();
    }
    @Override
    public ResultSet getBusNumber(String bus_id) throws SQLException, ClassNotFoundException {
       return busDAO.getBusNumber(bus_id);
    }
    @Override
    public ResultSet getIdsBUS() throws SQLException, ClassNotFoundException {
        return busDAO.getIds();
    }



}
