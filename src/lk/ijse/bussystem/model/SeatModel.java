package lk.ijse.bussystem.model;

import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.to.OrderDetails;
import lk.ijse.bussystem.to.Seat;
import lk.ijse.bussystem.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class SeatModel {

public  static boolean PlaceOrder(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
    try {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        boolean save = SeatModel.Save(orderDetails);
        if (save) {
            boolean paymentd = PaymentModel.Paymentd(orderDetails);
            if (paymentd) {
                DBConnection.getInstance().getConnection().commit();
                return true;
            }
        }
        DBConnection.getInstance().getConnection().rollback();
        return false;
    }finally {
        DBConnection.getInstance().getConnection().setAutoCommit(true);
    }
}




    public static boolean Save(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO seat VALUES (?,?,?)",
                orderDetails.getSeatid(),
                orderDetails.getBid(),
                orderDetails.getSeatprice()

        );
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM seat");
    }

    public static ResultSet getId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Seat_Id FROM seat ORDER BY  LENGTH(Seat_Id),Seat_Id");
    }

    public static boolean setSeat(String price, Object id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO seat VALUES (?,?)",id,price);
    }

    public static boolean updateSeat(String price, String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE seat SET Seat_Price=? WHERE Seat_Id=?",price,id);
    }

    public static ResultSet getData(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT Seat_Price FROM seat WHERE Seat_Id=?",id);
    }
/**මෙතන ශීට් 30 add වෙනකොට එකක  error එකක් ආවොත් එක නවත්තල ඔල්ලොම වදින්න ඔන නිස මෙ ක්‍රමෙ පාවිචි කරා
 * */
    public static boolean seatadded(LocalTime time, String from, String to) throws SQLException {
        System.out.println("on seat add method");
        Connection connection=null;
        try {
            connection=DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
           ResultSet set= getScgedulData(time,from,to);
           if (set.next()){
               System.out.println(" Schedule id " +set.getString(1));
               System.out.println(" Bus id " +set.getString(2));
               if (setSeats(set.getString(1),set.getString(2))){
                   System.out.println("commit");
                    connection.commit();
                    return true;
               }else {
                   System.out.println("roll back");
                   connection.rollback();
               }
           }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        System.out.println("return false ");
        return false;
    }

    private static boolean setSeats(String S_id, String bus_id) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < getSeatCount(bus_id); i++) {
            System.out.print("S"+(i+1)+" ,");
            System.out.print(bus_id+" ,");
            System.out.print("Available"+" ,");
            System.out.println(S_id);
            if (CrudUtil.execute("INSERT INTO seat_booking VALUES (?,?,?,?)","S"+(i+1),bus_id,"Available",S_id))
            {}else {
                System.out.println("return false in set Seat");
                return false;
            }
        }
        System.out.println("return true in set Seat");

        return true;
    }

    private static int getSeatCount(String bus_id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT b.seatCount FROM bus b WHERE Bus_Id=?",bus_id);
        if (set.next()){
            return Integer.parseInt(set.getString(1));
        }
        return 0;
    }

    private static ResultSet getScgedulData(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException {
      return   CrudUtil.execute("SELECT Schedule.schedule_id,Bus_Id FROM schedule WHERE time=? AND `to`=? AND  `from`=?",time,to,from);
    }

    public static boolean schedulExsist(LocalTime time, String from, String to) throws SQLException, ClassNotFoundException {
        ResultSet set=CrudUtil.execute("SELECT Schedule.schedule_id FROM schedule WHERE time=? AND `to`=? AND  `from`=?",time,to,from);
        return set.next();
    }

    public static boolean seatExsist(String id) throws SQLException, ClassNotFoundException {
       ResultSet set= CrudUtil.execute("SELECT * FROM seat_booking  WHERE schedule_id=?",id);
        return set.next();
    }
}
