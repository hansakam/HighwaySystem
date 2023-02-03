package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXTextField;
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
import lk.ijse.bussystem.bo.custom.DriverBO;
import lk.ijse.bussystem.bo.custom.impl.DriverBOImpl;
import lk.ijse.bussystem.dao.custom.DriverDAO;
import lk.ijse.bussystem.dao.custom.impl.DriverDAOImpl;
import lk.ijse.bussystem.tm.DriverTM;
import lk.ijse.bussystem.DTO.DriverDTO;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverFormController implements Initializable {

    DriverBO driverBO = new DriverBOImpl();

    public JFXTextField Txtid;
    public JFXTextField Txtname;
    public JFXTextField Txtaddress;
    public JFXTextField Txtemail;
    public JFXTextField Txtsalary;
    public JFXTextField Txtsearch;
    public TableView tblviewb;
    public TableColumn tbldid;
    public TableColumn tblname;
    public TableColumn tbladdress;
    public TableColumn tblemail;
    public TableColumn tblsalary;
    public Label lbldid;
    public Label lbldname;
    public Label lbladdress;
    public Label lblemail;
    private Matcher IdMatcher;
    private Matcher emailMatcher;
    private Matcher MemberNameMatcher;
    private Matcher AddressMatcher;


    ObservableList<DriverTM> DriverTMS = FXCollections.observableArrayList();

    public void btnsearchonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = Txtsearch.getText();

        DriverDTO driver = driverBO.SearchDriver(id);
        if (driver != null) {
            filldata(driver);
        }

    }

    public void filldata(DriverDTO driver) {
        Txtid.setText(driver.getEid());
        Txtname.setText(driver.getName());
        Txtaddress.setText(driver.getAddress());
        Txtemail.setText(driver.getEmail());
        Txtsalary.setText(String.valueOf(driver.getSalary())
        );
    }

    public void Btnadd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id = Txtid.getText();
        String name = Txtname.getText();
        String address = Txtaddress.getText();
        String email = Txtemail.getText();
        double salary = Double.parseDouble(Txtsalary.getText());

        DriverDTO driver = new DriverDTO(id, name, address, email, salary);

        boolean isadd =driverBO.SaveDriver(driver);
        if (isadd) {
            new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Wrong").show();
        }
    }

    public void Btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = Txtid.getText();
        String name = Txtname.getText();
        String address = Txtaddress.getText();
        String email = Txtemail.getText();
        double salary = Double.parseDouble(Txtsalary.getText());

        DriverDTO driver = new DriverDTO(id, name, address, email, salary);

        boolean isupdate =driverBO.UpdateDriver(driver);
        if (isupdate) {

            new Alert(Alert.AlertType.CONFIRMATION, "Update success").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong.!").show();
        }


    }


    public void Btndelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = Txtid.getText();
        boolean isDelete =driverBO.deleteDriver(id);
        if (isDelete) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successful...!").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbldid.setCellValueFactory(new PropertyValueFactory<>("did"));
        tblname.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        setTable();
        setPattern();

    }

    private void setTable() {
        tblviewb.getItems().clear();
        try {
            ResultSet set =driverBO.getAllDriver();
            while (set.next()) {
                DriverTMS.add(new DriverTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getDouble(5)

                ));
            }
            tblviewb.setItems(DriverTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setPattern(){
        Pattern MemberIdPattern = Pattern.compile("(C0)([1-9]{0,})");
        IdMatcher = MemberIdPattern.matcher(Txtid.getText());

        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        emailMatcher = emailPattern.matcher(Txtemail.getText());

        Pattern NamePattern = Pattern.compile("[a-zA-Z]{2,}");
        MemberNameMatcher = NamePattern.matcher(Txtname.getText());

        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{2,}$");
        AddressMatcher = addressPattern.matcher(Txtaddress.getText());
    }

    public void TxtDid(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^(D0)([0-9]{0,})$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtid.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lbldid.setText("*Invalid Driver ID (Start with - D0)");
        } else {
            lbldid.setText("");
        }


    }

    public void TxtDname(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^[a-zA-Z_ ]{2,}$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtname.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lbldname.setText("*Invalid Name Entry");
        } else {
            lbldname.setText("");
        }
    }

    public void TxtAddress(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^[a-zA-Z]{2,}$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtaddress.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lbladdress.setText("*Invalid Address Entry");

        } else {
            lbladdress.setText("");
        }
    }

    public void Txtemail(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtemail.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            // TxtMemberEmail.getParent().setStyle("-fx-border-color:red");
            lblemail.setText("*Invalid G mail Entry");
        } else {
            lblemail.setText("");
        }
    }
}
