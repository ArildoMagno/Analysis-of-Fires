package DAO;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import models.Region;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static satellite.Main.firebase;

/**
 * Apenas o objeto de acesso aos dados e seus getters e setters vulgo DAO
 */
public class RegionDAO {
    private static ArrayList<Region> regions;

    /**
     * @return array de regiões
     */
    public static ArrayList<Region> getRegions() {
        return regions;
    }

    /**
     * Construtor de classe apenas instancia o arrrayList
     */
    public RegionDAO() {
        regions = new ArrayList<>();
        this.readRegions();
    }

    private void readRegions() {
        //asynchronously retrieve multiple documents
        ApiFuture<QuerySnapshot> future =
                firebase.db.collection("regions").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                regions.add(document.toObject(Region.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /**
     * @param list coloca as regiões no dao
     */
    public static void setRegions(ArrayList<Region> list) {
        RegionDAO.regions = list;
    }
}
