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
import javafx.scene.layout.AnchorPane;
import lk.ijse.bussystem.bo.custom.BOFactory;
import lk.ijse.bussystem.bo.custom.BusBO;
import lk.ijse.bussystem.bo.custom.CustomerBO;
import lk.ijse.bussystem.bo.custom.SuperBO;
import lk.ijse.bussystem.bo.custom.impl.CustomerBOImpl;
import lk.ijse.bussystem.dao.custom.CustomerDAO;
import lk.ijse.bussystem.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.bussystem.tm.CustomerTM;
import lk.ijse.bussystem.DTO.CustomerDTO;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerFormController implements Initializable{


    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);


    public Label lblcustomerwrong;
    public Label lblcustomerwrongname;
    public Label lblcustomerwrongemail;
    public Label lblcustomerwrongaddress;
    private Matcher IdMatcher;
    private Matcher emailMatcher;
    private Matcher MemberNameMatcher;
    private Matcher AddressMatcher;

    public AnchorPane pane;
    public JFXTextField Txtid;
    public JFXTextField Txtname;
    public JFXTextField Txtaddress;
    public JFXTextField Txtemail;
    public JFXTextField txtSearched;
    public TableColumn tblcolcustomerid;
    public TableColumn tblcolcustomername;
    public TableColumn tblcolcustomeraddress;
    public TableColumn tblcolcustomeremail;
    public TableView Tblcus;

//create observer arralist

    ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();


    public void searchonaction(ActionEvent actionEvent)  {

        String id = txtSearched.getText();
        try {
            CustomerDTO customer = customerBO.SearchCustomer(id);
            if (customer != null) {

                fillData(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public  void fillData(CustomerDTO customer){
        System.out.println(customer.getId());
        Txtid.setText(customer.getId());
        Txtname.setText(customer.getName());
        Txtaddress.setText(customer.getAddress());
        Txtemail.setText(customer.getEmail());

    }

    public void updateonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id=Txtid.getText();
        String name=Txtname.getText();
        String address=Txtaddress.getText();
        String email=Txtemail.getText();


       CustomerDTO customer=new CustomerDTO(id,name,address,email);
        boolean isupdate = customerBO.UpdateCustomer(customer);

        if (isupdate){

            new Alert(Alert.AlertType.CONFIRMATION,"Update success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Something Wrong.!").show();
        }


    }


    public void Deleteonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean isDelete=customerBO.deleteCustomer(Txtid.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successful...!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }


    }

    public void BtnAddonaction(ActionEvent actionEvent) {

        String id=Txtid.getText();
        String name=Txtname.getText();
        String address=Txtaddress.getText();
        String email=Txtemail.getText();

        CustomerDTO customer=new CustomerDTO(id,name,address,email);
        try {
             boolean isadd=customerBO.SaveCustomer(customer);
            if (isadd) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    private void nextid(){
//
//        try {
//
//            ResultSet Set = CustomerDAOImpl.getLastId();
//            if (Set.next()) {
//                String[] c00 = Set.getString(1).split("C00");
//                int id = Integer.parseInt(c00[1]);
//                id++;
//                Txtid.setText("C00" + id);
//
//
//            } else {
//                Txtid.setText("C001");
//
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void newonaction(ActionEvent actionEvent) {

        //nextid();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblcolcustomerid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcolcustomername.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcolcustomeraddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblcolcustomeremail.setCellValueFactory(new PropertyValueFactory<>("email"));
        setTable();
        setPattern();
    }
    //table getall
    private void setTable() {
        Tblcus.getItems().clear();
        try {
            ResultSet set = customerBO.getAllCustomer();
            while (set.next()){
                customerTMS.add(new CustomerTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4)

                ));
            }
            Tblcus.setItems(customerTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void clear(){
        Txtid.setText("");
        Txtname.setText("");
        Txtaddress.setText("");
        Txtemail.setText("");

    }
    private  void setPattern(){
        Pattern MemberIdPattern = Pattern.compile("(C0)([1-9]{0,})");
        IdMatcher = MemberIdPattern.matcher(Txtid.getText());

        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        emailMatcher = emailPattern.matcher(Txtemail.getText());

        Pattern NamePattern = Pattern.compile("[a-zA-Z]{2,}");
        MemberNameMatcher = NamePattern.matcher(Txtname.getText());

        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{2,}$");
        AddressMatcher = addressPattern.matcher(Txtaddress.getText());

    }

    public void cusidonketyped(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^(C0)([0-9]{0,})$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtid.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lblcustomerwrong.setText("*Invalid Member ID (Start with - C0)");
        } else {
            lblcustomerwrong.setText("");
        }


    }

    public void cusnameonketyped(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^[a-zA-Z_ ]{2,}$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtname.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lblcustomerwrongname.setText("*Invalid Name Entry");
        } else {
            lblcustomerwrongname.setText("");
        }
    }

    public void cusaddressonketyped(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^[a-zA-Z]{2,}$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtaddress.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lblcustomerwrongaddress.setText("*Invalid Address Entry");

        } else {
            lblcustomerwrongaddress.setText("");
        }
    }

    public void cusemailonketyped(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtemail.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            // TxtMemberEmail.getParent().setStyle("-fx-border-color:red");
            lblcustomerwrongemail.setText("*Invalid G mail Entry");
        } else {
           lblcustomerwrongemail.setText("");
        }
    }
}
