package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.model.*;
import lk.ijse.bussystem.to.Payment;
import lk.ijse.bussystem.util.CrudUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SheatbookingController implements Initializable {

    public static ArrayList<String> seat = new ArrayList<>();
    public static SheatbookingController controller;
    public JFXComboBox cmdbusid;
    public Label lbltotal;
    public Label lblblance;
    public JFXComboBox cmbcusid;
    public Label lblbusnumber;
    public VBox vBox;
    public Label lblcusname;
    public JFXTextField lblFrom;
    public JFXTextField lblTo;
    public JFXTextField balance;
    public JFXButton btn;
    public JFXTimePicker time;

    public SheatbookingController() {
        controller = this;
    }

    public void cmbbusidonaction(ActionEvent actionEvent) {
       /* try {
            if (SeatBookingModel.seatExist(String.valueOf(cmdbusid.getValue()))) {

            } else {
                ResultSet resultSet= ScheduleModel.getData(String.valueOf(cmdbusid.getValue()));
                while (resultSet.next()){
                    ResultSet set = BusModel.getSeatcount(String.valueOf(cmdbusid.getValue()));
                    if (set.next()) {
                        SeatBookingModel.setSeat(Integer.parseInt(set.getString(1)), String.valueOf(cmdbusid.getValue()),resultSet.getString(1));
                    }
                }
            }
            ResultSet set = BusModel.getBusNumber(String.valueOf(cmdbusid.getValue()));
            if (set.next()) {
                lblbusnumber.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }*/
try {
    ResultSet set = BusModel.getBusNumber(String.valueOf(cmdbusid.getValue()));
    if (set.next()) {
        lblbusnumber.setText(set.getString(1));
    }
} catch (SQLException throwables) {
    throwables.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
    }

    private void setSeatdata() {

        vBox.getChildren().clear();
        try {

            ResultSet sets= CrudUtil.execute("SELECT Schedule.schedule_id from schedule where `from`=? and `to`=? and time=?",lblFrom.getText(),lblTo.getText(),time.getValue());
            String id=null;
            if (sets.next()){
                id=sets.getString(1);
            }
            System.out.println("ID : "+id);


            ResultSet set = SeatBookingModel.getAll(id,lblFrom.getText(),lblTo.getText(),time.getValue());
            while (set.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/bussystem/view/BookingBar.fxml"));
                Parent root = loader.load();
                BookingBarController controller = loader.getController();
                controller.setData(set.getString(1), set.getString(2), set.getString(3));
                vBox.getChildren().add(root);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Btnpay(ActionEvent actionEvent) {
        String pId=getId();
        try {
            if (PaymentModel.setPayment(new Payment(
                    pId,
                    lblFrom.getText(),
                    lblTo.getText(),
                    lbltotal.getText(),
                    String.valueOf(cmdbusid.getValue()),
                    String.valueOf(cmbcusid.getValue()),
                    getDate(),
                    getTime()

            ))) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").show();

//                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/bussystem/view/report/Bus_Tickt.jrxml");
                HashMap<String, Object> hm = new HashMap<>();
                hm.put("pId", pId);

                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(resource);
                    JasperPrint print = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getInstance().getConnection());
                    JasperViewer.viewReport(print, false);

                } catch (JRException e) {
                    throw new RuntimeException(e);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
//                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                seat.clear();
                cmbcusid.getItems().clear();
                setCustomerId();
                cmdbusid.getItems().clear();
                setBusId();
                lblcusname.setText("");
                lblbusnumber.setText("");
                lblFrom.clear();
                lblTo.clear();
                lbltotal.setText("00.00");
                lblblance.setText("00.00");
                balance.clear();
                BookingBarController.seatPrice.clear();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private String getId() {
        String id = null;
        try {
            ResultSet set = PaymentModel.getPaymentIds();
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] p = id.split("P");
                int nId = Integer.parseInt(p[1]);
                nId++;
                return "P" + nId;
            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                return "P1";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        return format.format(new Date());
    }

    private String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());

    }

    public void cmbcusidonaction(ActionEvent actionEvent) {
        try {
            ResultSet set = CustomerModel.getName(String.valueOf(cmbcusid.getValue()));
            if (set.next()) {
                lblcusname.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setCustomerId() {
        ArrayList<String> id = new ArrayList<>();
        try {
            ResultSet set = CustomerModel.getIds();
            while (set.next()) {
                id.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        cmbcusid.getItems().addAll(id);


    }

    private void setBusId() {
        ArrayList<String> id = new ArrayList<>();
        try {
            ResultSet set = BusModel.getIds();
            while (set.next()) {
                id.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        cmdbusid.getItems().setAll(id);
    }

    public void Btnbooking(ActionEvent actionEvent) {
        try {
            if (SeatBookingModel.updateAll()){
                new Alert(Alert.AlertType.CONFIRMATION,"All Booking cancel").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        setSeatdata();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBusId();
        setCustomerId();
    }

    public void givenBalanceOnkeyReleased(KeyEvent keyEvent) {

        Pattern pattern= Pattern.compile("^([+-]?[0-9]+(?:\\.[0-9]{0,4})?)$");
        Matcher matcher=pattern.matcher(balance.getText());
        if (matcher.matches()){
            try {
                lblblance.setText(String.valueOf(Double.valueOf(balance.getText()) - BookingBarController.total));
            }catch (NumberFormatException e){
                lblblance.setText(String.valueOf(0-BookingBarController.total));
            }
            if (Double.valueOf(lblblance.getText())  < 0) {
                btn.setDisable(true);
            } else {
                btn.setDisable(false);
            }
            balance.setStyle("-fx-text-fill: black");
        }else {
            btn.setDisable(true);
            balance.setStyle("-fx-text-fill: red");
        }

    }

    public void btnSearch(ActionEvent actionEvent) {
        try {
            setBusIdSearch();
            setSeatdata();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    private void setBusIdSearch() throws SQLException, ClassNotFoundException {
        System.out.println("on busIdSearch method ");
        if (SeatModel.schedulExsist(time.getValue(),lblFrom.getText(),lblTo.getText())){
            System.out.println("Schedule exists");

            ResultSet sets= CrudUtil.execute("SELECT Schedule.schedule_id from schedule where `from`=? and `to`=? and time=?",lblFrom.getText(),lblTo.getText(),time.getValue());
           String id=null;
            if (sets.next()){
                id=sets.getString(1);
            }

            System.out.println("ID : "+id);

            if(SeatModel.seatExsist(id)){
                System.out.println("Seat exists");
                ResultSet busId=CrudUtil.execute("SELECT DISTINCT bus_id FROM seat_booking WHERE schedule_id=?",id);
                if (busId.next()){
                    cmdbusid.setValue(busId.getString(1));
                }

            }else {
                if (SeatModel.seatadded(time.getValue(),lblFrom.getText(),lblTo.getText())){
                    System.out.println("added");
                }
            }


        }else {
            System.out.println("no schedule");
        }




    }
}
