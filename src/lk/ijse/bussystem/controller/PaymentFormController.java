package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentFormController {
    public JFXTextField Txtcusid;
    public JFXTextField Txtptype;
    public JFXTextField Txtpayid;
    public JFXTextField Txtstartingpoint;
    public JFXTextField Txtfrom;
    public JFXTextField Txtto;
    public JFXTextField Txtamount;
    public JFXTextField TxtBusid;
    public TableColumn Tblcusid;
    public TableColumn Tblbusid;
    public TableColumn TblAmount;
    public TableColumn Tblto;
    public TableColumn Tblfrom;
    public TableColumn Tblstarting;
    public TableColumn Tblptype;
    public TableColumn Tblpayid;
    public TableView TblPayment;
    public JFXTextField Txtsearch;

    public void Btnpay(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/bussystem/view/BillForm.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void BtnCancell(ActionEvent actionEvent) {
    }

    public void Btnsearch(ActionEvent actionEvent) {
    }
}
