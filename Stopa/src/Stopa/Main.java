package Stopa;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;



public class Main extends Application {
    public static Stage javaFXC;


    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("Stopa.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image image = new Image("/Stopa/icon-stopa.jpg");
        stage.getIcons().add(image);
        stage.setTitle("Foot examination");


        stage.show();
        javaFXC = stage;

    }
}