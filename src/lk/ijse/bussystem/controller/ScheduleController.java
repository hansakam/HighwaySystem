package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.bussystem.model.BusModel;
import lk.ijse.bussystem.model.ScheduleModel;
import lk.ijse.bussystem.to.Schedule;
import lk.ijse.bussystem.view.tm.ScheduleTm;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {
    public JFXTextField txtTo;
    public JFXTextField txtSearch;
    public JFXComboBox busId;
    public Label lblEid;
    public Label lblName;
    public Label lblEmail;
    public Label lblAddress;
    public Label txtBusNumber;
    public JFXTimePicker timeSchedule;
    public JFXTextField txtFrom;
    public JFXComboBox cmbFrom;
    public JFXComboBox cmbTo;
    public JFXCheckBox CheckFrom;
    public JFXCheckBox checkBoxTo;
    public TableView tblSchedule;
    public TableColumn tblBusId;
    public TableColumn tblFrom;
    public TableColumn tblTo;
    public TableColumn tblTime;
    ObservableList<ScheduleTm> scheduleTm = FXCollections.observableArrayList();

    public void Txtename(KeyEvent keyEvent) {
    }

    public void Btnsearch(ActionEvent actionEvent) {
        try {
            ResultSet set = ScheduleModel.getSrarch(txtSearch.getText());
            if (set.next()) {
                cmbFrom.setValue(set.getString(3));
                cmbTo.setValue(set.getString(4));
                busId.setValue(set.getString(1));
                tblSchedule.getItems().add(set.getString(2));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void BtnAddonaction(ActionEvent actionEvent) {
        try {
            if (ScheduleModel.setSchedule(new Schedule(
                    String.valueOf(busId.getValue()),
                    setFrom(),
                    setTo(),
                    String.valueOf(timeSchedule.getValue()),
                    getSId()
            ))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                if (checkBoxTo.isSelected()) {
                    txtTo.setText("");
                    checkBoxTo.fire();
                } else {
                    cmbTo.getItems().clear();
                    setToLocation();
                }
                if (CheckFrom.isSelected()) {
                    txtFrom.setText("");
                    CheckFrom.fire();
                } else {
                    busId.getItems().clear();
                    setBusId();
                }
                cmbFrom.getItems().clear();
                setFromLocation();
                timeSchedule.getEditor().clear();
                setTableData();
                txtBusNumber.setText("");

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private String getSId() {

        try {
            ResultSet set=ScheduleModel.getIds();
            String id=null;
            while (set.next()){
                id=set.getString(1);

            }
            try {
                String[] s = id.split("s00");
                int n= Integer.parseInt(s[1]);
                n++;
                return "s00"+n;
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return "s001";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

return "s001";
    }

    private String setTo() {
        String location = null;
        if (checkBoxTo.isSelected()) {
            location = txtTo.getText();
        } else {
            location = String.valueOf(cmbTo.getValue());
        }
        return location;
    }

    private String setFrom() {
        String location = null;
        if (CheckFrom.isSelected()) {
            location = txtFrom.getText();
        } else {
            location = String.valueOf(cmbFrom.getValue());
        }
        return location;
    }

    public void BtnupdateOnaction(ActionEvent actionEvent) {
        try {
            if (ScheduleModel.updateSchedule(
                    new Schedule(
                            String.valueOf(busId.getValue()),
                            setFrom(),
                            setTo(),
                            String.valueOf(timeSchedule.getValue()),
                            txtSearch.getText()
                    )
            )) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                if (checkBoxTo.isSelected()) {
                    txtTo.setText("");
                    checkBoxTo.fire();
                } else {
                    cmbTo.getItems().clear();
                    setToLocation();
                }
                if (CheckFrom.isSelected()) {
                    txtFrom.setText("");
                    CheckFrom.fire();
                } else {
                    busId.getItems().clear();
                    setBusId();
                }
                cmbFrom.getItems().clear();
                setFromLocation();
                timeSchedule.getEditor().clear();
                setTableData();
                txtBusNumber.setText("");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void BtndeleteonAction(ActionEvent actionEvent) {
        try {
            if (ScheduleModel.remove(txtSearch.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "remove").show();
                txtSearch.setText("");
                if (checkBoxTo.isSelected()) {
                    txtTo.setText("");
                    checkBoxTo.fire();
                } else {
                    cmbTo.getItems().clear();
                    setToLocation();
                }
                if (CheckFrom.isSelected()) {
                    txtFrom.setText("");
                    CheckFrom.fire();
                } else {
                    busId.getItems().clear();
                    setBusId();
                }
                cmbFrom.getItems().clear();
                setFromLocation();
                timeSchedule.getEditor().clear();
                setTableData();
                txtBusNumber.setText("");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void checkBoxFromOnAction(ActionEvent actionEvent) {
        if (CheckFrom.isSelected()) {
            cmbFrom.setVisible(false);
            txtFrom.setVisible(true);
        } else {
            cmbFrom.setVisible(true);
            txtFrom.setVisible(false);
        }
    }

    public void checkBoxToOnAction(ActionEvent actionEvent) {
        if (checkBoxTo.isSelected()) {
            cmbTo.setVisible(false);
            txtTo.setVisible(true);
        } else {
            cmbTo.setVisible(true);
            txtTo.setVisible(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTableData();
        setFromLocation();
        setToLocation();
        setBusId();
        tblBusId.setCellValueFactory(new PropertyValueFactory<>("busId"));
        tblFrom.setCellValueFactory(new PropertyValueFactory<>("from"));
        tblTo.setCellValueFactory(new PropertyValueFactory<>("to"));
        tblTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tblSchedule.setItems(scheduleTm);
    }

    private void setTableData() {
        scheduleTm.clear();
        tblSchedule.getItems().clear();
        try {
            ResultSet set = ScheduleModel.getAll();
            while (set.next()) {
                scheduleTm.add(new ScheduleTm(
                        set.getString(1),
                        set.getString(3),
                        set.getString(4),
                        set.getString(2)
                ));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        tblSchedule.refresh();

    }

    private void setTableSearchData() {
        scheduleTm.clear();
        tblSchedule.getItems().clear();
        try {
            ResultSet set = ScheduleModel.getAll(txtSearch.getText());
            while (set.next()) {
                scheduleTm.add(new ScheduleTm(
                        set.getString(1),
                        set.getString(3),
                        set.getString(4),
                        set.getString(2)

                ));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        tblSchedule.refresh();

    }

    private void setBusId() {
        try {
            ArrayList<String> data = new ArrayList<>();
            ResultSet set = BusModel.getIds();
            while (set.next()) {
                data.add(set.getString(1));
            }
            busId.getItems().setAll(data);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void setToLocation() {
        try {
            ArrayList<String> data = new ArrayList<>();
            ResultSet set = ScheduleModel.getAllToLocation();
            while (set.next()) {
                data.add(set.getString(1));
            }
            cmbTo.getItems().setAll(data);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void setFromLocation() {
        try {
            ArrayList<String> data = new ArrayList<>();
            ResultSet set = ScheduleModel.getAllFromLocation();
            while (set.next()) {
                data.add(set.getString(1));
            }
            cmbFrom.getItems().setAll(data);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void busIdOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = BusModel.getBusNumber(String.valueOf(busId.getValue()));
            if (set.next()) {
                txtBusNumber.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void searchID(KeyEvent keyEvent) {
        if (txtSearch.getText().equals("")) {
            setTableData();

            if (checkBoxTo.isSelected()) {
                txtTo.setText("");
                checkBoxTo.fire();
            } else {
                cmbTo.getItems().clear();
                setToLocation();
            }
            if (CheckFrom.isSelected()) {
                txtFrom.setText("");
                CheckFrom.fire();
            } else {
                busId.getItems().clear();
                setBusId();
            }
            cmbFrom.getItems().clear();
            setFromLocation();
            timeSchedule.getEditor().clear();
            setTableData();
            txtBusNumber.setText("");

        } else {
            setTableSearchData();
        }

    }
}
