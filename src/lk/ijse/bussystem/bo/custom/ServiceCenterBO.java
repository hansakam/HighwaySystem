package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.DTO.ServiceCenterDTO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ServiceCenterBO extends SuperBO{
    boolean SaveServiceCenter(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException;

    boolean UpdateServiceCenter(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException;

    ServiceCenterDTO SearchServiceCenter(String id) throws SQLException, ClassNotFoundException;

    boolean deleteServiceCenter(String id) throws SQLException, ClassNotFoundException;

    ResultSet getAllServiceCenter() throws SQLException, ClassNotFoundException;
}
