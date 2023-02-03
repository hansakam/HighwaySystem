package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.bussystem.bo.custom.EmployeeBO;
import lk.ijse.bussystem.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.bussystem.dao.custom.EmployeeDAO;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.bussystem.tm.EmployeeTM;
import lk.ijse.bussystem.DTO.EmployeeDTO;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeFormController implements Initializable {

    EmployeeBO employeeBO = new EmployeeBOImpl();


    public JFXTextField Txtempid;
    public JFXTextField Txtname;
    public JFXTextField Txtaddress;
    public JFXTextField Txtserviceid;
    public JFXTextField Txtsalary;
    public JFXTextField Txtemail;
    public JFXComboBox combosid;
    public TableColumn Tblsname;
    public TableColumn tblserid;
    public TableView servicetable;
    public JFXTextField Txtsearch;
    public TableView Tblemployeeview;
    public TableColumn Tbleid;
    public TableColumn Tblname;
    public TableColumn Tbladdresss;
    public TableColumn Tblmail;
    public TableColumn Tblsalary;
    public TableColumn Tblserviceid;
    public Label lbleid;
    public Label lblname;
    public Label lblemail;
    public Label lbladdress;
    private Matcher IdMatcher;
    private Matcher emailMatcher;
    private Matcher MemberNameMatcher;
    private Matcher AddressMatcher;

    //String combo[]={" Service001"};
        ArrayList<String>comboo=new ArrayList<>();
    ObservableList<EmployeeTM> EmployeeTMS = FXCollections.observableArrayList();

    public void BtnAddonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id=Txtempid.getText();
        String name=Txtname.getText();
        String address=Txtaddress.getText();
        String email=Txtemail.getText();
        double salary= Double.parseDouble(Txtsalary.getText());
        String sid = String.valueOf(combosid.getValue());

        EmployeeDTO employee=new EmployeeDTO(id,name,address,email,salary,sid);
        boolean issave =employeeBO.SaveEmployee(employee);
       if(issave){
           new Alert(Alert.AlertType.CONFIRMATION,"Sucess").show();
       }else {
           new Alert(Alert.AlertType.WARNING,"Try to Save").show();
       }

        setTable();

    }

    public void BtnupdateOnaction(ActionEvent actionEvent) {
        String id=Txtempid.getText();
        String name=Txtname.getText();
        String address=Txtaddress.getText();
        String email=Txtemail.getText();
        double salary= Double.parseDouble(Txtsalary.getText());
        String sid= String.valueOf(combosid.getValue());

        EmployeeDTO employee=new EmployeeDTO(id,name,address,email,salary);
        try {
            boolean isupdate=employeeBO.UpdateEmployee(employee);
            if (isupdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void BtndeleteonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete=employeeBO.deleteEmployee(Txtempid.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successful...!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }


    }

    //create combo box
    public void loadStaffId(){
        String sql = "Select Service_Id from  SERVICE_CENTER ";
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ObservableList<String> data = FXCollections.observableArrayList();
            while (resultSet.next()){
                data.add(resultSet.getString(1));
                combosid.setItems(data);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tbleid.setCellValueFactory(new PropertyValueFactory<>("Empid"));
        Tblname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tbladdresss.setCellValueFactory(new PropertyValueFactory<>("address"));
        Tblmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        Tblsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        Tblserviceid.setCellValueFactory(new PropertyValueFactory<>("serviceid"));

        setTable();
        loadStaffId();
        setPattern();

    }
    private void setTable() {
       Tblemployeeview .getItems().clear();
        try {
            ResultSet set =employeeBO.getAllEmployee();
            while (set.next()){
                EmployeeTMS.add(new EmployeeTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getDouble(5),
                        set.getString(6)

                ));
            }
            Tblemployeeview.setItems(EmployeeTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Btnsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = Txtsearch.getText();
        try {
            EmployeeDTO employee =employeeBO.SearchEmployee(id);
            if (employee != null) {

                fillData(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public  void fillData(EmployeeDTO employee){

        Txtempid.setText(employee.getEmp_id());
        Txtname.setText(employee.getName());
        Txtaddress.setText(employee.getAddress());
        Txtemail.setText(employee.getE_mail());
        Txtsalary.setText(String.valueOf(employee.getSalary()));


    }
    private  void setPattern(){
        Pattern MemberIdPattern = Pattern.compile("(C0)([1-9]{0,})");
        IdMatcher = MemberIdPattern.matcher(Txtempid.getText());

        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        emailMatcher = emailPattern.matcher(Txtemail.getText());

        Pattern NamePattern = Pattern.compile("[a-zA-Z]{2,}");
        MemberNameMatcher = NamePattern.matcher(Txtname.getText());

        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{2,}$");
        AddressMatcher = addressPattern.matcher(Txtaddress.getText());

    }

    public void Txteid(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^(E0)([0-9]{0,})$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtempid.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lbleid.setText("*Invalid Member ID (Start with - E0)");
        } else {
            lbleid.setText("");
        }
    }

    public void Txtename(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("^[a-zA-Z_ ]{2,}$");
        Matcher empIDmatcher = empIDpattern.matcher(Txtname.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            lblname.setText("*Invalid Name Entry");
        } else {
            lblname.setText("");
        }
    }

    public void Txteaddress(KeyEvent keyEvent) {
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
