/**
 * @author :Hansaka Malshan
 * created 2/3/2023---2:44 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.ServiceCenterDTO;
import lk.ijse.bussystem.bo.custom.ServiceCenterBO;
import lk.ijse.bussystem.dao.custom.ServiceCenterDAO;
import lk.ijse.bussystem.dao.custom.impl.ServicecenterDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceCenterBOImpl implements ServiceCenterBO {

    ServiceCenterDAO servicecenterDAO = new ServicecenterDAOImpl();

    @Override
    public boolean SaveServiceCenter(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException {
        return servicecenterDAO.Save(dto);
    }

    @Override
    public boolean UpdateServiceCenter(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException {
        return servicecenterDAO.Update(dto);
    }

    @Override
    public ServiceCenterDTO SearchServiceCenter(String id) throws SQLException, ClassNotFoundException {
        return servicecenterDAO.Search(id);
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
