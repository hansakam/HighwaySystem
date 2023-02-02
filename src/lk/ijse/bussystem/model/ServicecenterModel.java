package lk.ijse.bussystem.model;

import lk.ijse.bussystem.to.Customer;
import lk.ijse.bussystem.to.ServiceCenter;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicecenterModel {


    public static boolean Save(ServiceCenter serviceCenter) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO service_center VALUES (?,?,?,?,?,?,?)",
               serviceCenter.getSid(),
                serviceCenter.getName(),
                serviceCenter.getLocation(),
                serviceCenter.getContact(),
                serviceCenter.getTask(),
                serviceCenter.getDate(),
                serviceCenter.getBid()
        );
    }

    public static ServiceCenter search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM service_center WHERE Service_Id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {

            return new ServiceCenter(
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

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM service_center WHERE Service_Id='"+id+"'";
        return CrudUtil.execute(sql);
    }

    public static boolean Update(ServiceCenter serviceCenter) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE service_center SET Name=?,Location=?,contact=?,task=?,date=?, Bus_Id=? WHERE Service_Id=? ");
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM SERVICE_CENTER");
    }
}
