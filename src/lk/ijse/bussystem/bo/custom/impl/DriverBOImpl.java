/**
 * @author :Hansaka Malshan
 * created 2/3/2023---12:01 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.CustomerDTO;
import lk.ijse.bussystem.DTO.DriverDTO;
import lk.ijse.bussystem.bo.custom.DriverBO;
import lk.ijse.bussystem.dao.custom.DriverDAO;
import lk.ijse.bussystem.dao.custom.impl.DriverDAOImpl;
import lk.ijse.bussystem.entity.DriverEntity;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverBOImpl implements DriverBO {
    DriverDAO driverDAO = new DriverDAOImpl();


    @Override
    public boolean SaveDriver(DriverDTO dto) throws SQLException, ClassNotFoundException {
       return driverDAO.Save(new DriverEntity(dto.getEid(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getSalary()));
    }

    @Override
    public boolean UpdateDriver(DriverDTO dto) throws SQLException, ClassNotFoundException {
        return driverDAO.Update(new DriverEntity(dto.getEid(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getSalary()));
    }

    @Override
    public DriverDTO SearchDriver(String id) throws SQLException, ClassNotFoundException {
        DriverEntity search = driverDAO.Search(id);
        return new DriverDTO(search.getDriver_Id(),search.getName(),search.getAddress(),search.getE_mail(),search.getSalary());
    }

    @Override
    public boolean deleteDriver(String id) throws SQLException, ClassNotFoundException {
        return driverDAO.delete(id);
    }

    @Override
    public ResultSet getAllDriver() throws SQLException, ClassNotFoundException {
        return driverDAO.getAll();
    }
}
