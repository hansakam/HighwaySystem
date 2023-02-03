/**
 * @author :Hansaka Malshan
 * created 2/3/2023---12:01 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.DriverDTO;
import lk.ijse.bussystem.bo.custom.DriverBO;
import lk.ijse.bussystem.dao.custom.DriverDAO;
import lk.ijse.bussystem.dao.custom.impl.DriverDAOImpl;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverBOImpl implements DriverBO {
    DriverDAO driverDAO = new DriverDAOImpl();


    @Override
    public boolean SaveDriver(DriverDTO dto) throws SQLException, ClassNotFoundException {
       return driverDAO.Save(dto);
    }

    @Override
    public boolean UpdateDriver(DriverDTO dto) throws SQLException, ClassNotFoundException {
        return driverDAO.Update(dto);
    }

    @Override
    public DriverDTO SearchDriver(String id) throws SQLException, ClassNotFoundException {
        return driverDAO.Search(id);
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
