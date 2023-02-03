/**
 * @author :Hansaka Malshan
 * created 2/3/2023---12:01 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.DTO.BusDTO;
import lk.ijse.bussystem.bo.custom.BusBO;
import lk.ijse.bussystem.dao.custom.BusDAO;
import lk.ijse.bussystem.dao.custom.impl.BusDAOImpl;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusBOImpl implements BusBO {

    BusDAO busDAO = new BusDAOImpl();
    @Override
    public boolean SaveBUS(BusDTO dto) throws SQLException, ClassNotFoundException {
       return busDAO.Save(dto);
    }
    @Override
    public boolean UpdateBUS(BusDTO dto) throws SQLException, ClassNotFoundException {
        return busDAO.Update(dto);
    }
    @Override
    public BusDTO SearchBUS(String id) throws SQLException, ClassNotFoundException {
      return busDAO.Search(id);
    }
    @Override
    public boolean deleteBUS(String id) throws SQLException, ClassNotFoundException {
     return busDAO.delete(id);
    }
    @Override
    public ResultSet getAllBUS() throws SQLException, ClassNotFoundException {
        return busDAO.getAll();
    }
    @Override
    public ResultSet getBusNumber(String bus_id) throws SQLException, ClassNotFoundException {
       return busDAO.getBusNumber(bus_id);
    }
    @Override
    public ResultSet getIdsBUS() throws SQLException, ClassNotFoundException {
        return busDAO.getIds();
    }



}
