package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.bussystem.util.CrudUtil;
import lk.ijse.bussystem.util.Navigation;
import lk.ijse.bussystem.util.Route;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class DashboardFormAdminController implements Initializable {
    public AnchorPane Pane1;
    public Pane tatoo;
    public JFXTextField timeid;
    public Label dateid;
    public Label timeids;
    public TextField Txttimes;
    public Text Txtcus;
    public Text TxtDriverid;
    public Text Txtbus;
    @FXML
    private AnchorPane pane;

    public void customeronAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm.fxml");
    }

    public void busonaction(ActionEvent actionEvent) throws IOException {
        setUi("BusForm.fxml");
    }

    public void reportonaction(ActionEvent actionEvent) throws IOException {
        setUi("ReportForm.fxml");
    }

    public void viewseatonaction(ActionEvent actionEvent) throws IOException {
        setUi("Sheatbooking.fxml");
    }

    public void employeeonaction(ActionEvent actionEvent) throws IOException {
        setUi("EmployeeForm.fxml");
    }

    public void servicecenteronaction(ActionEvent actionEvent) throws IOException {
        setUi("ServicecenterForm.fxml");
    }

    public void driveronaction(ActionEvent actionEvent) throws IOException {
        setUi("DriverForm.fxml");
    }

    public void logoutonaction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.UserForm, pane);
    }

    public void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource("/lk/ijse/bussystem/view/" + ui));
        tatoo.getChildren().clear();
        tatoo.getChildren().add(node);
    }

    public void dashonaction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.DashboardFormAdmin, pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        setTime();
        setTxtcus();
        setTxtDriverid();
        setTxtbus();

    }

    private void setDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateid.setText(dateFormat.format(new Date()));
    }

    private void setTime() {
//        try {
//            Thread clock = new Thread() {
//                public void run() {
//                    while (true) {
//                        SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
//                        Txttimes.setText(hour.format(new Date()));
//
//                        try {
//                            sleep(1000);
//                        } catch (InterruptedException ex) {
//                        }
//                    }
//                }
//            };
//            clock.start();
//        } catch (Exception e) {
//
//        }

      new Thread(() -> {
          SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
                        while (true){
                            Txttimes.setText(hour.format(new Date()));
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
      }).start();


    }


    private void setTxtcus() {
        try {
            String sql = "SELECT COUNT(*) FROM Customer";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int Customer = result.getInt(1);
                Txtcus.setText(String.valueOf(Customer));
            }
        } catch (Exception ex) {

        }
    }

    private void setTxtDriverid() {
        try {
            String sql = "SELECT COUNT(*) FROM Driver";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int driver = result.getInt(1);
                TxtDriverid.setText(String.valueOf(driver));
            }
        } catch (Exception ex) {

        }
    }

    private void setTxtbus() {
        try {
            String sql = "SELECT COUNT(*) FROM Bus";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int bus = result.getInt(1);
                Txtbus.setText(String.valueOf(bus));
            }
        } catch (Exception ex) {

        }
    }

    public void schudelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SchudelForm.fxml");
    }

    public void seatOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Seat.fxml");
    }
}

