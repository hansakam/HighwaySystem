package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import lk.ijse.bussystem.bo.custom.BOFactory;
import lk.ijse.bussystem.bo.custom.QueryBO;
import lk.ijse.bussystem.bo.custom.SeatBookingBO;
import lk.ijse.bussystem.dao.QueryDAO;
import lk.ijse.bussystem.dao.custom.SeatBookingDAO;
import lk.ijse.bussystem.dao.custom.impl.QueryDAOImpl;
import lk.ijse.bussystem.dao.custom.impl.SeatBookingDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingBarController {


//    SeatBookingDAO seatBookingDAO = new SeatBookingDAOImpl();
//    QueryDAO queryDAO = new QueryDAOImpl();
        private final SeatBookingBO seatBookingBO= (SeatBookingBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SEATBOOKING);
        private final QueryBO queryBO = (QueryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.QUERY);

    public Text id;
    public Text cheatNo;
    public JFXButton btn;
    public Text status;
    public static double total;
    public static ArrayList<Double> seatPrice=new ArrayList<>();

    public void setData(String id, String sNo, String status) {

        this.id.setText(id);
        String[] s = id.split("S");
        System.out.println("sNo  "+sNo);
        System.out.println("id  "+id);
        cheatNo.setText("Seat " + s[1]);
        this.status.setText(status);
        if (status.equals("Available")){
            btn.setText("ADD");
        }if (status.equals("Booked")){
            btn.setText("CANCEL");
        }
    }

    public boolean btnOnAction(ActionEvent actionEvent) {

        try {
            if (btn.getText().equals("CANCEL")) {
                ResultSet set= queryBO.getSeatPrice(String.valueOf(SheatbookingController.controller.cmdbusid.getValue()));
                if (set.next()){
                    seatPrice.remove(Double.parseDouble(set.getString(1)));
                }
                for (int i = 0; i < SheatbookingController.seat.size(); i++) {
                    if (SheatbookingController.seat.get(i).equals(id.getText())){
                        SheatbookingController.seat.remove(i);
                    }
                }

                if (seatBookingBO.updateStatusSeatBooking(id.getText(), "Available")) {
                    new Alert(Alert.AlertType.CONFIRMATION, "cancel").show();
                    btn.setText("ADD");
                }

                return false;
            }
            if (btn.getText().equals("ADD")) {

               ResultSet set=queryBO.getSeatPrice(String.valueOf(SheatbookingController.controller.cmdbusid.getValue()));
               if (set.next()){
                   seatPrice.add(Double.parseDouble(set.getString(1)));
               }

                total();
                SheatbookingController.seat.add(id.getText());
                if (seatBookingBO.updateStatusSeatBooking(id.getText(), "Booked")) {
                    new Alert(Alert.AlertType.CONFIRMATION, "booked").show();
                    btn.setText("CANCEL");
                }

                return false;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    private void total(){
        total=0;
        for (int i = 0; i < seatPrice.size(); i++) {
            total+=seatPrice.get(i);
        }
        SheatbookingController.controller.lbltotal.setText(String.valueOf(total));
    }


}
