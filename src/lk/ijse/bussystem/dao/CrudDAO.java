package lk.ijse.bussystem.dao;

import java.sql.SQLException;

public interface CrudDAO<T,id> {
    boolean Save(T dto) throws SQLException, ClassNotFoundException;
    boolean Update(T dto) throws SQLException, ClassNotFoundException;
    T Search(id id)throws SQLException,ClassNotFoundException;
    boolean delete(id id) throws SQLException, ClassNotFoundException;
}
