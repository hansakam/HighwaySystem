import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class Appinitializer extends Application {
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("/lk/ijse/bussystem/view/DashboardFormAdmin.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();



    }
}
