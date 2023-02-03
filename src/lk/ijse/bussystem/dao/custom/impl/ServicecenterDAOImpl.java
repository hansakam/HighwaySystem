package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.ServiceCenterDTO;
import lk.ijse.bussystem.dao.custom.ServiceCenterDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicecenterDAOImpl implements ServiceCenterDAO {

    //updete error
    @Override
    public boolean Save(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO service_center VALUES (?,?,?,?,?,?,?)",
                dto.getSid(),
                dto.getName(),
                dto.getLocation(),
                dto.getContact(),
                dto.getTask(),
                dto.getDate(),
                dto.getBid()
        );
    }

    @Override
    public boolean Update(ServiceCenterDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ServiceCenterDTO Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM service_center WHERE Service_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {

            return new ServiceCenterDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getString(6),
                    result.getString(7)

            );
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM service_center WHERE Service_Id='"+id+"'";
        return CrudUtil.execute(sql);
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM SERVICE_CENTER");
    }
}
