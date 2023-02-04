/**
 * @author :Hansaka Malshan
 * created 2/3/2023---2:44 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.ServiceCenterDTO;
import lk.ijse.bussystem.bo.custom.ServiceCenterBO;
import lk.ijse.bussystem.dao.custom.ServiceCenterDAO;
import lk.ijse.bussystem.dao.custom.impl.ServicecenterDAOImpl;
import lk.ijse.bussystem.entity.Service_CenterEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceCenterBOImpl implements ServiceCenterBO {

    ServiceCenterDAO servicecenterDAO = new ServicecenterDAOImpl();

    @Override
    public boolean SaveServiceCenter(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException {
        return servicecenterDAO.Save(new Service_CenterEntity(dto.getSid(),dto.getName(),dto.getLocation(),dto.getContact(),dto.getTask(),dto.getDate(),dto.getBid()));
    }

    @Override
    public boolean UpdateServiceCenter(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ServiceCenterDTO SearchServiceCenter(String id) throws SQLException, ClassNotFoundException {
        Service_CenterEntity search = servicecenterDAO.Search(id);
        return  new ServiceCenterDTO(search.getService_Id(),search.getName(),search.getLocation(),search.getContact(),search.getTask_Total_Cost(),search.getDate(),search.getService_Id());
    }

    @Override
    public boolean deleteServiceCenter(String id) throws SQLException, ClassNotFoundException {
        return servicecenterDAO.delete(id);
    }

    @Override
    public ResultSet getAllServiceCenter() throws SQLException, ClassNotFoundException {
        return servicecenterDAO.getAll();
    }
}
