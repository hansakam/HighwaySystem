package lk.ijse.bussystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Route route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case DashboardFormAdmin:
                window.setTitle("UserForm");
                initUI("DashboardFormAdmin.fxml");
                break;
            case CustomerForm:
                window.setTitle("CustomerForm");
                initUI("CustomerForm.fxml");
                break;
            case BusForm:
                window.setTitle("BusForm");
                initUI("BusForm.fxml");
                break;
            case Sheatbooking:
                window.setTitle("SeatForm");
                initUI("Sheatbooking.fxml");
                break;
            case BillForm:
                window.setTitle("BillForm");
                initUI("BillForm.fxml");
                break;
            case ServicecenterForm:
                window.setTitle("ServicecenterForm");
                initUI("ServicecenterForm.fxml");
                break;
            case EmployeeForm:
                window.setTitle("EmployeeForm");
                initUI("EmployeeForm.fxml");
                break;
            case ReportForm:
                window.setTitle("ReportForm");
                initUI("ReportForm.fxml");
                break;
            case UserForm:
                window.setTitle("UserForm");
                initUI("UserForm.fxml");
                break;



        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/BusSystem/view/" + location)));
    }
    }

