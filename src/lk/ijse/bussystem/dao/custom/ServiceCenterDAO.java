package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.ServiceCenterDTO;
import lk.ijse.bussystem.dao.CrudDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ServiceCenterDAO extends CrudDAO<ServiceCenterDTO,String> {

    ResultSet getAll() throws SQLException, ClassNotFoundException;

}
