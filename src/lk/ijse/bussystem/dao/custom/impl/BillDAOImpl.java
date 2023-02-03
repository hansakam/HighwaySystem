package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.BillDTO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDAOImpl {
    public static BillDTO search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT *FROM BILL SET Payment_Id=?,Description=?,Num_Of_Passenger=?,Amount_Paid =?,Date=?," +
                "Time,Customer_Id=? WHERE Bill_Id=? ";
         ResultSet resultSet=CrudUtil.execute(id,sql);
         if (resultSet.next()){
             return new BillDTO(
                     resultSet.getString(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getDouble(4),
                     resultSet.getDouble(5),
                     resultSet.getString(6),
                     resultSet.getString(7),
                     resultSet.getString(8)
             );


         }
        return null;
           }
    }

