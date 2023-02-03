package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.DriverDTO;
import lk.ijse.bussystem.dao.custom.DriverDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDAOImpl implements DriverDAO {
    @Override
    public boolean Save(DriverDTO dto) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO DRIVER VALUES(?,?,?,?,?)";
        return CrudUtil.execute(sql,dto.getEid(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getSalary());
    }

    @Override
    public boolean Update(DriverDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Driver SET name=?,address=?,`e-mail`=?,salary=? WHERE Driver_Id=? ",

                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getSalary(),
                dto.getEid()
        ) ;
    }

    @Override
    public DriverDTO Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM driver WHERE Driver_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new DriverDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5)

            );
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Driver WHERE Driver_Id = '"+id+"' ");
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *FROM DRIVER ");
    }
}
