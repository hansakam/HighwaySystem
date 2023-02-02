package lk.ijse.bussystem.model;

import lk.ijse.bussystem.to.Driver;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverModel {

    public static boolean add(Driver driver) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO DRIVER VALUES(?,?,?,?,?)";
        return CrudUtil.execute(sql,driver.getEid(),driver.getName(),driver.getAddress(),driver.getEmail(),driver.getSalary());
    }

    public static boolean Update(Driver driver) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Driver SET name=?,address=?,`e-mail`=?,salary=? WHERE Driver_Id=? ",

                driver.getName(),
                driver.getAddress(),
                driver.getEmail(),
                driver.getSalary(),
                driver.getEid()
        ) ;

    }

    public static Driver Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM driver WHERE Driver_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            // System.out.println(" on If");
            //  System.out.println(result.getString(1));
            return new Driver(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5)

            );
        }
        return null;
    }

    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Driver WHERE Driver_Id = '"+id+"' ");

    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *FROM DRIVER ");
    }
}
