package satellite;

import DAO.ImageDAO;
import DAO.RegionDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tools.Firebase;

public class Main extends Application {

    public static Firebase firebase;
    /**
     * Apenas para inicar a telinha
     * @param stage telinha
     * @throws Exception retorna exception
     */
    @Override
    public void  start(Stage stage) throws Exception {
        firebase = new Firebase();
        ImageDAO imageDAO =  new ImageDAO();
        RegionDAO regionDAO = new RegionDAO();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Index.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Amazonia Satelite");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Roda a janela principal
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}
