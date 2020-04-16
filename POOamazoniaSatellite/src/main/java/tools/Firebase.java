package tools;
//import com.google.api.core.ApiFuture;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.firestore.*;
//
//import com.google.cloud.storage.BlobId;
//import com.google.cloud.storage.BlobInfo;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class Firebase {

    private GoogleCredentials credentials ;
    private FirebaseOptions options ;
    public Firestore db;
    public Storage storage ;

    public Firebase() throws IOException {
        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("credentials.json");
        this.credentials = GoogleCredentials.fromStream(serviceAccount);
        this.options = new FirebaseOptions.Builder()
                .setDatabaseUrl("https://poo-queimadas.firebaseio.com")
                .setStorageBucket("poo-queimadas.appspot.com")
                .setCredentials(credentials)
                .build();

        FirebaseApp.initializeApp(options);


        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();

        storage = storageOptions.getService();


        this.db = FirestoreClient.getFirestore();
    }

    public String uploadFile(String path, String fileName){



        BlobId blobId = BlobId.of(options.getStorageBucket(), fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/x-portable-pixmap").build();
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();

        InputStream  file= null;
        try {
            file = new FileInputStream(path+fileName);
            return storage.create(blobInfo, file).getBlobId().toString();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
        return null;
    }



    void deleteCollection(int batchSize) {


        try {
            // retrieve a small batch of documents to avoid out-of-memory errors
            ApiFuture<QuerySnapshot> future = collection.limit(batchSize).get();
            int deleted = 0;
            // future.get() blocks on document retrieval
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                document.getReference().delete();
                ++deleted;
            }
            if (deleted >= batchSize) {
                // retrieve and delete another batch
                deleteCollection(collection, batchSize);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados : " + e.getMessage());
        }


    }
}
