package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.BusDTO;
import lk.ijse.bussystem.dao.custom.BusDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusDAOImpl implements BusDAO {

    @Override
    public ResultSet getBusNumber(String bus_id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Bus_Number FROM bus WHERE Bus_Id=?",bus_id);
    }

    @Override
    public ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT bus_id FROM bus");
    }
    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *FROM BUS");
    }

    @Override
    public boolean Save(BusDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO BUS VALUES(?,?,?,?,?)",
                dto.getId(),
                dto.getCapasity(),
                dto.getBusnumber(),
                dto.getSeatid(),
                dto.getSeat()

        );
    }

    @Override
    public boolean Update(BusDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE BUS SET Capasity=?, Bus_Number=? WHERE Bus_Id=?",
                dto.getCapasity(),
                dto.getBusnumber(),
                dto.getId(),
                dto.getSeat(),
                dto.getSeatid()
                //update eka error
        );
    }

    @Override
    public BusDTO Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Bus WHERE  Bus_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);
        if (result.next()) {

            return new BusDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)




            );
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM bus WHERE Bus_Id ='" + id + "'";
       return CrudUtil.execute(sql);
    }
}
