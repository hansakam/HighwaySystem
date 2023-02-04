package lk.ijse.bussystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bussystem.bo.custom.BOFactory;
import lk.ijse.bussystem.bo.custom.ServiceCenterBO;
import lk.ijse.bussystem.bo.custom.SuperBO;
import lk.ijse.bussystem.bo.custom.impl.ServiceCenterBOImpl;
import lk.ijse.bussystem.dao.custom.ServiceCenterDAO;
import lk.ijse.bussystem.db.DBConnection;
import lk.ijse.bussystem.dao.custom.impl.ServicecenterDAOImpl;
import lk.ijse.bussystem.tm.ServiceCenterTM;
import lk.ijse.bussystem.DTO.ServiceCenterDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ServicecenterFormController implements Initializable {

   private final ServiceCenterBO serviceCenterBO= (ServiceCenterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SERVICECENTER);

    public JFXTextField Txtsearch;
    public JFXTextField Txtid;
    public JFXTextField Txtcontact;
    public JFXTextField Txttask;
    public JFXTextField Txtname;
    public JFXTextField Txtlocation;
    public Label lblDate;
    public TableView TBLServicecenter;
    public TableColumn Tblserviceid;
    public TableColumn Tblname;
    public TableColumn Tbllocation;
    public TableColumn Tblcontact;
    public TableColumn Tbltotalcost;
    public TableColumn Tbldate;
    public TableColumn Tblbusid;
    public JFXTextField Txtbusid;
    public JFXComboBox combid;
    public Label lblcontact;
    public Label lbllocation;
    public Label lbldate;
    public Label lblname;

ObservableList<ServiceCenterTM>ServicecenterTMS=FXCollections.observableArrayList();

    public void Btnonsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id = Txtsearch.getText();

            ServiceCenterDTO serviceCenter =serviceCenterBO.SearchServiceCenter(id);
            if (serviceCenter != null) {
                fillData(serviceCenter);
            }

    }
    public  void fillData(ServiceCenterDTO serviceCenter){

        Txtid.setText(serviceCenter.getSid());
        lblname.setText(serviceCenter.getName());
        lbllocation.setText(serviceCenter.getLocation());
        lblcontact.setText(serviceCenter.getContact());
        Txttask.setText(String.valueOf(serviceCenter.getTask()));
        lbldate.setText(serviceCenter.getDate());
        combid.getValue();

    }

    public void Btnremove(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isdelete =serviceCenterBO.deleteServiceCenter(Txtid.getText());

        if(isdelete){
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successful...!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
    }

    public void BtnServicedetails(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/bussystem/view/ServiceDetails.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void Btnadd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id=Txtid.getText();
        String name=lblname.getText();
        String location=lbllocation.getText();
        String contact=lblcontact.getText();
        double cost= Double.parseDouble(Txttask.getText());
        String date=lbldate.getText();
        String bid= String.valueOf(combid.getValue());

        ServiceCenterDTO serviceCenter = new ServiceCenterDTO(id,name,location,contact,cost,date,bid);

        boolean isadd = serviceCenterBO.SaveServiceCenter(serviceCenter);
        if (isadd) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added  SUCCESS!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }


    public void combobox(ActionEvent actionEvent) {
    }
    private void setDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        lbldate.setText(dateFormat.format(new Date()));
    }
    //create combobox
    public void loadbusid(){
        String sql = "Select Bus_Id from  Bus ";
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ObservableList<String> data = FXCollections.observableArrayList();
            while (resultSet.next()) {
                data.add(resultSet.getString(1));
                combid.setItems(data);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Tblserviceid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        Tblname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tbllocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        Tblcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        Tbltotalcost.setCellValueFactory(new PropertyValueFactory<>("task"));
        Tbldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Tblbusid.setCellValueFactory(new PropertyValueFactory<>("bid"));


        setDate();
        loadbusid();
        setTable();
    }
    //load servicetable
    private void setTable() {
        TBLServicecenter.getItems().clear();
        try {
            ResultSet set =serviceCenterBO.getAllServiceCenter();
            while (set.next()){
                ServicecenterTMS.add(new ServiceCenterTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getDouble(5),
                        set.getString(6),
                        set.getString(7)


                ));
            }
            TBLServicecenter.setItems(ServicecenterTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Btnupdate(ActionEvent actionEvent) {
        String id=Txtid.getText();
        String name=lblname.getText();
        String location=lbllocation.getText();
        String contact=lblcontact.getText();
        double cost= Double.parseDouble(Txttask.getText());
        String date=lblDate.getText();
        String bid= String.valueOf(combid.getValue());



        ServiceCenterDTO serviceCenter=new ServiceCenterDTO(id,name,location,contact,cost,date,bid);



        try {
            boolean isupdate =serviceCenterBO.UpdateServiceCenter(serviceCenter);
            if (isupdate){

                new Alert(Alert.AlertType.CONFIRMATION,"Update success").show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something Wrong.!").show();
            }
        } catch (Exception throwables) {
            System.out.println(throwables);
        }



    }
}
