import DAO.RegionDAO;
import models.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import tools.Image;

import javax.swing.*;

/**
 * Classe apenas para controlle do botão de satellite
 */
public class Satellite {
    @FXML
    Button btnGenerate;

    /**
     * Função que precorre as regiões cadastradas gera e envia a imagem para o drive para cada região cadastrada
     */
    public void sendData(){
        Image imageTool =  null;
        for (Region region : RegionDAO.getRegions()){
            imageTool = new Image(5,100);
            imageTool.generateImageFile(region.getId());
        }
        JOptionPane.showMessageDialog(null, "Imagens das regiões enviadas com sucesso!");
    }
}
