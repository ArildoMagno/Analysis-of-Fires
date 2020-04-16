import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller da tela principal do javafx
 */
public class Controller {

    @FXML
    private BorderPane borderPanel;

    /**
     * @param ui nome do xml
     */
    @FXML
    private void loadUI(String ui) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        borderPanel.setCenter(root);
    }

    /**
     * carrega a interface de enviar os dados
     */
    public void loadSattellite(){
        this.loadUI("satelite");
    }
}
