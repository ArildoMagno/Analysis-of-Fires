import DAO.RegionDAO;
import DAO.SquadDAO;
import models.Region;
import models.Squad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static analysis.Main.firebase;

public class ControllerEditarDadosSquad extends ControllerUtil {


    @FXML
    private ComboBox<java.lang.String> comboBoxSquadEditar;

    @FXML
    private TextField txtNomeEditarSquad;

    @FXML
    private TextField txtNumeroEditarSquad;

    @FXML
    private ComboBox<java.lang.String> checkBregiaoEditarSquad;


    /**
     * carrega os dados para a checkbox
     * @throws ExecutionException execao para quando esta executando
     * @throws InterruptedException excao por sofrer uma interrupcao enquanto esta executando
     */
    @FXML
    public void carregarCheckBoxRegion() throws ExecutionException, InterruptedException {
        SquadDAO squadDAO = new SquadDAO();
        ObservableList<String> olcomboBoxSquadResponsable = null;
        //dentro da .carregarComboBox tem o try catch já
        olcomboBoxSquadResponsable = FXCollections.observableList(squadDAO.carregarComboBox(firebase));
        checkBregiaoEditarSquad.setItems(olcomboBoxSquadResponsable);
    }


    /**
     * carrega os dados para a chebox do squad
     * @throws ExecutionException excecao para tempo de execucao
     * @throws InterruptedException excecao para sofrer uma interrupcao enquanto executa
     */
    @FXML
    public void carregarCheckBoxSquad() throws ExecutionException, InterruptedException {
        SquadDAO squadDAO = new SquadDAO();
        ObservableList<String> olcomboBoxSquadResponsable = null;
        //dentro da .carregarComboBox tem o try catch já
        olcomboBoxSquadResponsable = FXCollections.observableList(squadDAO.carregarComboBoxEditarDados(firebase));
        comboBoxSquadEditar.setItems(olcomboBoxSquadResponsable);

    }


    /**
     * atualiza os dados que tem na checkbox
     * @throws ExecutionException  excecao para tempo de execucao
     * @throws InterruptedException excecao para sofrer uma interrupcao enquanto executa
     */
    @FXML
    public void atualizarDadosCheckBoxSquad() throws ExecutionException, InterruptedException {

        SquadDAO squadDAO = new SquadDAO();
        List<Squad> listaSquads = null;
        ObservableList<Squad> olcomboBoxSquadResponsable;

        //dentro da .carregarComboBox tem o try catch já
        olcomboBoxSquadResponsable = FXCollections.observableList(squadDAO.carregarComboBoxSquad(firebase));
        String nomeSquad = " ", nomeSquadPuro = " ", sQuantityOfSoldiers;
        String idText = " ";
        int quantityOfSoldiers = 0;

        for (int i = 0; i < olcomboBoxSquadResponsable.size(); i++) {
            nomeSquad = String.valueOf(olcomboBoxSquadResponsable.get(i).getName());
            nomeSquadPuro = String.valueOf(olcomboBoxSquadResponsable.get(i).getName());
            nomeSquad = nomeSquad.concat("  -> id: ");
            idText = Integer.toString(i);
            nomeSquad = nomeSquad.concat(idText);



            if (comboBoxSquadEditar.getValue().equals(nomeSquad)) {//se o olcomboBox get String name == ao comboBox, atribui os dados
                txtNomeEditarSquad.setText(nomeSquadPuro);
                quantityOfSoldiers = olcomboBoxSquadResponsable.get(i).getQuantityOfSoldiers();
                sQuantityOfSoldiers = Integer.toString(quantityOfSoldiers);
                txtNumeroEditarSquad.setText(sQuantityOfSoldiers);
            }
        }


    }


    /**
     * remove um esquadrao
     * @throws GeneralSecurityException excecao para seguranca
     * @throws ExecutionException excecao em tempo de execucao
     * @throws InterruptedException execao para quando sofre uma interrupcao em tempo de execucao
     */
    @FXML
    public void removerSquad() throws GeneralSecurityException, ExecutionException, InterruptedException {

        SquadDAO squadDAO = new SquadDAO();

        ObservableList<Squad> olcomboBoxSquadResponsable;

        olcomboBoxSquadResponsable = FXCollections.observableList(squadDAO.carregarComboBoxSquad(firebase));


        String nomeSquad = " ", nomeSquadPuro = " ", sQuantityOfSoldiers, nomeSquadAux = " ";
        String idText = " ", nomeRegion = " ", nomeRegionPuro = " ";
        int quantityOfSoldiers = 0, t = 0, nomeSquadIntAux = 0;

        for (int i = 0; i < olcomboBoxSquadResponsable.size(); i++) {
            nomeSquad = String.valueOf(olcomboBoxSquadResponsable.get(i).getName());
            nomeSquadPuro = String.valueOf(olcomboBoxSquadResponsable.get(i).getName());
            nomeSquad = nomeSquad.concat("  -> id: ");
            idText = Integer.toString(i);
            nomeSquad = nomeSquad.concat(idText);


            if (comboBoxSquadEditar.getValue().equals(nomeSquad)) {
                nomeSquadIntAux = olcomboBoxSquadResponsable.get(i).getId();
                nomeSquadAux = Integer.toString(nomeSquadIntAux);
                firebase.remove("squads", nomeSquadAux);
                JOptionPane.showMessageDialog(null, "Acao Concluida", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }


    /**
     * Salva um novo Esquadrao
     * @throws IOException excecao de entrada e saida
     * @throws GeneralSecurityException execao para seguranca
     * @throws ExecutionException para quando estiver executando
     * @throws InterruptedException caso sofra uma interrupcao
     */
    @FXML
    public void botaoSalvarSquad() throws IOException, GeneralSecurityException, ExecutionException, InterruptedException {

        SquadDAO squadDAO = new SquadDAO();
        RegionDAO regionDAO = new RegionDAO();
        ObservableList<Region> olcomboBoxRegionResponsable;
        ObservableList<Squad> olcomboBoxSquadResponsable;
        //dentro da .carregarComboBox tem o try catch já
        olcomboBoxSquadResponsable = FXCollections.observableList(squadDAO.carregarComboBoxSquad(firebase));
        olcomboBoxRegionResponsable = FXCollections.observableList(regionDAO.carregarComboBoxEditarDados(firebase));


        String nomeSquad = " ", nomeSquadPuro = " ", sQuantityOfSoldiers;
        String idText = " ", nomeRegion = " ", nomeRegionPuro = " ";
        int quantityOfSoldiers = 0, t = 0;

        for (int i = 0; i < olcomboBoxSquadResponsable.size(); i++) {
            nomeSquad = String.valueOf(olcomboBoxSquadResponsable.get(i).getName());
            nomeSquadPuro = String.valueOf(olcomboBoxSquadResponsable.get(i).getName());
            nomeSquad = nomeSquad.concat("  -> id: ");
            idText = Integer.toString(i);
            nomeSquad = nomeSquad.concat(idText);


            if (comboBoxSquadEditar.getValue().equals(nomeSquad)) {//se o olcomboBox get String name == ao comboBox, atribui os dados
                // java.lang.String quantify = Integer.toString(listaSquads.get(i).getQuantityOfSoldiers());
                olcomboBoxSquadResponsable.get(i).setName(txtNomeEditarSquad.getText());
                sQuantityOfSoldiers = txtNumeroEditarSquad.getText();
                quantityOfSoldiers = Integer.parseInt(sQuantityOfSoldiers);
                olcomboBoxSquadResponsable.get(i).setQuantityOfSoldiers(quantityOfSoldiers);

                //p pegar a region responsable :
                for (t = 0; t < olcomboBoxRegionResponsable.size(); t++) {
                    nomeRegionPuro = String.valueOf(olcomboBoxRegionResponsable.get(t).getName());
                    nomeRegion = String.valueOf(olcomboBoxRegionResponsable.get(t).getName());
                    nomeRegion = nomeRegion.concat("  -> id: ");
                    idText = Integer.toString(i);
                    nomeRegion = nomeRegion.concat(idText);

                    //concat com o id, p verificar e na hr de add só o nome normal o puro por isso

                    if (checkBregiaoEditarSquad.getValue().equals(nomeRegion)) {
                        olcomboBoxSquadResponsable.get(i).setRegionResponsable(nomeRegion);
                    }
                }
                //dentro do write tem o try catch já
                firebase.write(1, olcomboBoxSquadResponsable.get(i).getId(), olcomboBoxSquadResponsable.get(i).getName(), null, 0, " ", " ", olcomboBoxSquadResponsable.get(i).getQuantityOfSoldiers(), olcomboBoxSquadResponsable.get(i).getRegionResponsable());
                JOptionPane.showMessageDialog(null, "Acao Concluida", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }


    }


}
