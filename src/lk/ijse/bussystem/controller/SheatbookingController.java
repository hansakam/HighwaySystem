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
import lk.ijse.bussystem.bo.custom.*;
import lk.ijse.bussystem.bo.custom.impl.BusBOImpl;
import lk.ijse.bussystem.bo.custom.impl.CustomerBOImpl;
import lk.ijse.bussystem.bo.custom.impl.SeatBookingBOImpl;
import lk.ijse.bussystem.dao.QueryDAO;
import lk.ijse.bussystem.dao.custom.*;
import lk.ijse.bussystem.dao.custom.impl.*;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.DTO.PaymentDTO;
import lk.ijse.bussystem.util.CrudUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SheatbookingController implements Initializable {

    private final SeatBO seatBO = (SeatBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SEAT);
    private final PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);
    private final BusBO busBO= (BusBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BUS);
    private final CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    private final ScheduleBO scheduleBO = (ScheduleBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SCHEDULE);
    private final SeatBookingBO seatBookingBO= (SeatBookingBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SEATBOOKING);
    private final QueryBO queryBO = (QueryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.QUERY);



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

        try {
    ResultSet set = busBO.getBusNumber(String.valueOf(cmdbusid.getValue()));
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
            String from=lblFrom.getText();
            String to=lblTo.getText();
            LocalTime tim=time.getValue();

            ResultSet sets= CrudUtil.execute("SELECT Schedule.schedule_id from schedule where `from`=? and `to`=? and time=?",from,to,tim);
            String id=null;
            if (sets.next()){
                id=sets.getString(1);
            }
            System.out.println("ID : "+id);


            ResultSet set =queryBO.getAll(id,lblFrom.getText(),lblTo.getText(),time.getValue());

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
            if (paymentBO.setPayment(new PaymentDTO(
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
            ResultSet set =paymentBO.getPaymentIds();
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
            ResultSet set =customerBO.getNameCustomer(String.valueOf(cmbcusid.getValue()));
            if (set.next()) {
                lblcusname.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
//combo box
    private void setCustomerId() {
        ArrayList<String> id = new ArrayList<>();
        try {
            ResultSet set = customerBO.getIdsCustomer();
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
            ResultSet set =busBO.getIdsBUS();
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
            if (seatBookingBO.updateAllSeatBooking()){
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
        if (scheduleBO.schedulExsist(time.getValue(),lblFrom.getText(),lblTo.getText())){
            System.out.println("Schedule exists");

            ResultSet sets= CrudUtil.execute("SELECT Schedule.schedule_id from schedule where `from`=? and `to`=? and time=?",lblFrom.getText(),lblTo.getText(),time.getValue());
            String id=null;
            if (sets.next()){
                id=sets.getString(1);
            }

            System.out.println("ID : "+id);

            if(seatBO.seatExsist(id)){
                System.out.println("Seat exists");
                ResultSet busId=CrudUtil.execute("SELECT DISTINCT bus_id FROM seat_booking WHERE schedule_id=?",id);
                if (busId.next()){
                    cmdbusid.setValue(busId.getString(1));
                }

            }else {

                if (seatBO.seatadded(time.getValue(),lblFrom.getText(),lblTo.getText())){
                    System.out.println("added");
                }
            }
        }else {
            System.out.println("no schedule");
        }

    }
}
