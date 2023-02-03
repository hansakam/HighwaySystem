package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.bussystem.dao.custom.impl.BillDAOImpl;
import lk.ijse.bussystem.DTO.BillDTO;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BillFormController implements Initializable {

    public JFXTextField TxtbillId;
    public JFXTextField TxtpaymentId;
    public JFXTextField Txtdescription;
    public JFXTextField Txtdate;
    public JFXTextField Txtnopassenger;
    public JFXTextField Txtammount;
    public JFXTextField Txttime;
    public JFXTextField Txtcusid;
    public Label Lbldate;
    public JFXTextField TxtSearch;
    public Label Lbltime;


    public void Btnticketonaction(ActionEvent actionEvent) {
        String id=TxtbillId.getText();
        String pid=TxtpaymentId.getText();
        String description=Txtdescription.getText();
        double passenger= Double.parseDouble(Txtnopassenger.getText());
        double amount= Double.parseDouble(Txtammount.getText());
        String cid=Txtcusid.getText();




    }

    public void Btnsearchonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id=TxtbillId.getText();

        BillDTO bill= BillDAOImpl.search(id);
        if (bill != null){
            fillData(bill);
        }


    }
    public  void fillData(BillDTO bill){

        TxtbillId.setText(bill.getBill_id());
        TxtpaymentId.setText(bill.getPayment_id());
        Txtdescription.setText(bill.getDescription());
        Txtnopassenger.setText(String.valueOf(bill.getNo_of_Passenger()));
        Txtammount.setText(String.valueOf(bill.getAmount()));
        Txtdate.setText(bill.getDate());
        Txttime.setText(bill.getTime());
        Txtcusid.setText(bill.getCusId());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadOrderDate();
    }
    private void loadOrderDate() {
        Lbldate.setText(String.valueOf(LocalDate.now()));
    }

}
