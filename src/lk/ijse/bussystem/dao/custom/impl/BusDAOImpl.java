package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.BusDTO;
import lk.ijse.bussystem.dao.custom.BusDAO;
import lk.ijse.bussystem.entity.BusEntity;
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
    public boolean Save(BusEntity busEntity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO BUS VALUES(?,?,?,?,?)",
                busEntity.getBus_Id(),
                busEntity.getCapasity(),
                busEntity.getBus_Number(),
                busEntity.getSeat_id(),
                busEntity.getSeatCount()

        );
    }

    @Override
    public boolean Update(BusEntity busEntity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE BUS SET Capasity=?, Bus_Number=? WHERE Bus_Id=?",
                busEntity.getCapasity(),
                busEntity.getBus_Number(),
                busEntity.getSeatCount(),
                busEntity.getSeat_id(),
                busEntity.getBus_Id()
                //update eka error
        );
    }

    @Override
    public BusEntity Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Bus WHERE  Bus_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);
        if (result.next()) {

            return new BusEntity(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5)




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
