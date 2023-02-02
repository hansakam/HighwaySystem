package lk.ijse.bussystem.model;

import lk.ijse.bussystem.to.Customer;
import lk.ijse.bussystem.to.Employee;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {

    public static boolean Save(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Employee VALUES(?,?,?,?,?,?)",
                employee.getEmp_id(),
                employee.getName(),
                employee.getAddress(),
                employee.getE_mail(),
                employee.getSalary(),
                employee.getSid()

        );
    }

    public static Employee search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Employee WHERE Emp_Id=?";
        ResultSet result = CrudUtil.execute(sql,id);

        if (result.next()) {

            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5)



            );
        }
        return null;
    }
    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Employee");
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Employee WHERE Emp_Id='" + id + "'";
        return CrudUtil.execute(sql);
    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Employee SET name=?,address=?,`E-mail`=?,salary=? WHERE Emp_Id=?",
                employee.getName(),
                employee.getAddress(),
                employee.getE_mail(),
                employee.getSalary(),
                employee.getEmp_id()
        );

    }
}

