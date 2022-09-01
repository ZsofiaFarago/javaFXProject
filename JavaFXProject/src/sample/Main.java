package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Lottó program");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
		System.out.printl("Hello World")>
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
