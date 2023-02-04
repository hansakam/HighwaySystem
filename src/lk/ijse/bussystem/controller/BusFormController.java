package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.ijse.bussystem.bo.custom.BOFactory;
import lk.ijse.bussystem.bo.custom.BusBO;
import lk.ijse.bussystem.bo.custom.SuperBO;
import lk.ijse.bussystem.bo.custom.impl.BusBOImpl;
import lk.ijse.bussystem.dao.custom.BusDAO;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.dao.custom.impl.BusDAOImpl;
import lk.ijse.bussystem.tm.BusTM;
import lk.ijse.bussystem.DTO.BusDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusFormController implements Initializable {


   private final BusBO busBO= (BusBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BUS);

    public JFXTextField Txtbusid;
    public JFXTextField Txtsearch;
    public JFXTextField Txtbusnumber;
    public JFXTextField Txtcapasity;
    public TableColumn Tblbusnumber;
    public TableColumn Tblcapasity;
    public TableColumn TblbusType;
    public TableColumn Tblbusid;
    public TableView Tblbusview;
    public JFXRadioButton Rdononac;
    public JFXRadioButton Rdoac;
    public ToggleGroup bus;
    public JFXTextField ACNONAcOnAction;
    public JFXTextField ACNONAcOnAction1;
    public Label lblbusid;
    public JFXTextField Txtbusseatid;
    public TableColumn Tblseat;
    public JFXComboBox cmbseatid;
    public TableColumn Tblseatid;
    private Matcher IdMatcher;

    ObservableList<BusTM>busTMS= FXCollections.observableArrayList();

    public void BtnAddonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id=Txtbusid.getText();
        String capasity=Txtcapasity.getText();
        String busnumber=Txtbusnumber.getText();
        String seat=Txtbusseatid.getText();
        String seatid= String.valueOf(cmbseatid.getValue());

        BusDTO bus=new BusDTO(id,capasity,busnumber,seat,seatid);
        boolean isadd =busBO.SaveBUS(bus);
        if(isadd){
           new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"warning").show();

        }


    }

    public void Btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        String id=Txtbusid.getText();
        String capasity=Txtcapasity.getText();
        String busnumber=Txtbusnumber.getText();
        String seat=Txtbusseatid.getText();
        String seatid= String.valueOf(cmbseatid.getValue());

        BusDTO bus=new BusDTO(id,capasity,busnumber,seat,seatid);

        boolean isUpdate=busBO.UpdateBUS(bus);
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Warning").show();
        }
    }

    public void BtnAddtoservice(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/bussystem/view/ServicecenterForm.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void BtnsearchOnaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String sid=Txtsearch.getText();
       BusDTO bus=busBO.SearchBUS(sid);
       if (bus!=null){
           filldata(bus);
       }

    }

    public void filldata(BusDTO bus){
        Txtbusid.setText(bus.getId());
        Txtcapasity.setText(bus.getCapasity());
        Txtbusnumber.setText(bus.getBusnumber());


    }

    public void loadStaffId(){
        String sql = "Select Seat_Id from  seat ";
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ObservableList<String> data = FXCollections.observableArrayList();
            while (resultSet.next()){
                data.add(resultSet.getString(1));
                cmbseatid.setItems(data);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tblbusid.setCellValueFactory(new PropertyValueFactory<>("bid"));
        Tblcapasity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        Tblbusnumber.setCellValueFactory(new PropertyValueFactory<>("bnumber"));
        Tblseat.setCellValueFactory(new  PropertyValueFactory<>("seat"));
        Tblseatid.setCellValueFactory(new  PropertyValueFactory<>("seatid"));

        setTable();
        clear();
        setPattern();
        loadStaffId();
    }

    private void setTable() {
        Tblbusview.getItems().clear();
        try {
            ResultSet set =busBO.getAllBUS();
            while (set.next()){
                busTMS.add(new BusTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(5),
                        set.getString(4)


                ));
            }
            Tblbusview.setItems(busTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear(){
        Txtbusid.setText("");
        Txtcapasity.setText("");
        Txtbusnumber.setText("");


    }

    public void Btnremove(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete=busBO.deleteBUS(Txtbusid.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successful...!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }

    }

    private void setPattern(){
        Pattern MemberIdPattern = Pattern.compile("(B0)([1-9]{0,})");
       IdMatcher = MemberIdPattern.matcher(Txtbusid.getText());

    }

    public void txtbusidonkeytyped(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^(B0)([0-9]{0,})$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtbusid.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lblbusid.setText("*Invalid Member ID (Start with - B0)");
        } else {
            lblbusid.setText("");
        }
    }
}

