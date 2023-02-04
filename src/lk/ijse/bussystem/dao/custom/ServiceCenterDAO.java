package lk.ijse.bussystem.dao.custom;

import lk.ijse.bussystem.DTO.ServiceCenterDTO;
import lk.ijse.bussystem.dao.CrudDAO;
import lk.ijse.bussystem.entity.Service_CenterEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ServiceCenterDAO extends CrudDAO<Service_CenterEntity,String> {

    ResultSet getAll() throws SQLException, ClassNotFoundException;

}
