package lk.ijse.bussystem.dao.custom.impl;

import lk.ijse.bussystem.DTO.EmployeeDTO;
import lk.ijse.bussystem.dao.custom.EmployeeDAO;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean Save(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Employee VALUES(?,?,?,?,?,?)",
                dto.getEmp_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getE_mail(),
                dto.getSalary(),
                dto.getSid()

        );
    }

    @Override
    public boolean Update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Employee SET name=?,address=?,`E-mail`=?,salary=? WHERE Emp_Id=?",
                dto.getName(),
                dto.getAddress(),
                dto.getE_mail(),
                dto.getSalary(),
                dto.getEmp_id()
        );
    }

    @Override
    public EmployeeDTO Search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Employee WHERE Emp_Id=?";
        ResultSet result = CrudUtil.execute(sql,id);

        if (result.next()) {

            return new EmployeeDTO(
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
        String sql = "DELETE FROM Employee WHERE Emp_Id='" + id + "'";
       return CrudUtil.execute(sql);
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Employee");
    }

//    public static boolean Save(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("INSERT INTO Employee VALUES(?,?,?,?,?,?)",
//                employee.getEmp_id(),
//                employee.getName(),
//                employee.getAddress(),
//                employee.getE_mail(),
//                employee.getSalary(),
//                employee.getSid()
//
//        );
//    }
//
//    public static EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT * FROM Employee WHERE Emp_Id=?";
//        ResultSet result = CrudUtil.execute(sql,id);
//
//        if (result.next()) {
//
//            return new EmployeeDTO(
//                    result.getString(1),
//                    result.getString(2),
//                    result.getString(3),
//                    result.getString(4),
//                    result.getDouble(5)
//
//
//
//            );
//        }
//        return null;
//    }
//    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM Employee");
//    }
//
//    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
//        String sql = "DELETE FROM Employee WHERE Emp_Id='" + id + "'";
//        return CrudUtil.execute(sql);
//    }
//
//    public static boolean update(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("UPDATE Employee SET name=?,address=?,`E-mail`=?,salary=? WHERE Emp_Id=?",
//                employee.getName(),
//                employee.getAddress(),
//                employee.getE_mail(),
//                employee.getSalary(),
//                employee.getEmp_id()
//        );
//
//    }
}

