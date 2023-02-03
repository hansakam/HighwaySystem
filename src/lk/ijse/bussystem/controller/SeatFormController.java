package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.bussystem.dao.custom.SeatDAO;
import lk.ijse.bussystem.dao.custom.impl.SeatDAOImpl;
import lk.ijse.bussystem.view.tm.SeatTm;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SeatFormController implements Initializable {

    SeatDAO seatDAO = new SeatDAOImpl();

    public JFXTextField txtPrice;
    public TableView tblView;
    public TableColumn tblSeatId;
    public TableColumn tblPrice;
    public JFXTextField txtId;
    ObservableList<SeatTm> tms = FXCollections.observableArrayList();

    public void TxtDid(KeyEvent keyEvent) {
        try {

            ResultSet set= seatDAO.getData(txtId.getText());
            if (set.next()){
                txtPrice.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Btnadd(ActionEvent actionEvent) {
        try {
            if (seatDAO.setSeat(txtPrice.getText(), nextId())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                txtPrice.clear();
                setTableData();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
//genarate id from get id
    private Object nextId() {
        String id=null;
        try {
            ResultSet set = seatDAO.getId();
            while (set.next()){
                id=set.getString(1);
            }
            try {
                String[] s = id.split("Se00");
                int n= Integer.parseInt(s[1]);
                n++;
                return "Se00"+n;
            }catch (NullPointerException e){
                return "Se001";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void Btnupdate(ActionEvent actionEvent) {
        try {
            if (seatDAO.updateSeat(txtPrice.getText(),txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION,"Ok").show();
                txtId.clear();
                txtPrice.clear();
                setTableData();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblSeatId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblView.setItems(tms);

        setTableData();

    }

    private void setTableData() {
        tms.clear();
        try {
            ResultSet set = seatDAO.getAll();
            while (set.next()) {
                SeatTm tm = new SeatTm();
                tm.setId(set.getString(1));
                tm.setPrice(set.getString(2));
                tms.add(tm);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}






