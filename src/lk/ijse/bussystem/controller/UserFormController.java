package lk.ijse.bussystem.controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.bussystem.util.Navigation;
import lk.ijse.bussystem.util.Route;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;


public class UserFormController implements Initializable {

    private Matcher userNameMatcher;
    private Matcher pwMatcher;

    public JFXButton logid;
    public JFXTextField UserNameId;
    public Label lblpassword;
    public Label lblUsername;
    public Label lbllogin;
    public AnchorPane pane;
    public JFXPasswordField Passordid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPattern();
        
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
       // if(UserNameId.getText().equals("Hansaka")&& Passordid.getText().equals("HANSAKA!@#$1234ha")){
            Navigation.navigate(Route.DashboardFormAdmin,pane);
       // }else {
         //   lbllogin.setText("Invalid UserName or Password");
       // }
    }


    public void UsernameOnaction(ActionEvent actionEvent) {
        Passordid.requestFocus();
    }


    public void UsernameOnkey(KeyEvent keyEvent) {
        Pattern userNamePattern = Pattern.compile("(^[a-zA-Z0-9]{4,}$)");
        userNameMatcher = userNamePattern.matcher(UserNameId.getText());

        if(!userNameMatcher.matches()) {
//            System.out.println(txtUserName.getText());
            UserNameId.requestFocus();
            UserNameId.setFocusColor(Paint.valueOf("Red"));
            lblUsername.setText("invalid user name");
        }else{
            UserNameId.setFocusColor(Paint.valueOf("blue"));
            lblUsername.setVisible(false);
        }

    }

    public void Passwordonaction(ActionEvent actionEvent) {

        logid.fire();
    }

    public void passwordonkey(KeyEvent keyEvent) {
        Pattern pwPattern = Pattern.compile("(^(?=.?[A-Z])(?=.?[a-z])(?=.?[0-9])(?=.?[#?!@$%^&*-]).{8,}$)");
        pwMatcher = pwPattern.matcher(Passordid.getText());

        if(!pwMatcher.matches()) {
//            System.out.println(txtUserName.getText());
            Passordid.requestFocus();
            Passordid.setFocusColor(Paint.valueOf("Red"));
            lblpassword.setText("invalid password");
        }else{
            Passordid.setFocusColor(Paint.valueOf("blue"));
            lblpassword.setVisible(false);
        }

    }
    private void setPattern(){

    }
    }

