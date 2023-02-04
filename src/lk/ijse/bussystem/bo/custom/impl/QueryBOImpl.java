/**
 * @author :Hansaka Malshan
 * created 2/4/2023---3:01 PM
 */
package lk.ijse.bussystem.bo.custom.impl;

import lk.ijse.bussystem.bo.custom.QueryBO;
import lk.ijse.bussystem.dao.DAOFactory;
import lk.ijse.bussystem.dao.QueryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class QueryBOImpl implements QueryBO {


     QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.QUERY);

    @Override
    public ResultSet getSeatPrice(String id) throws SQLException, ClassNotFoundException {
        return queryDAO.getSeatPrice(id);

    }

    @Override
    public ResultSet getAll(String id, String from, String to, LocalTime time) throws SQLException, ClassNotFoundException {
        return  queryDAO.getAll(id,from,to,time);
    }
}
