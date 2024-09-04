/* package org.zoodevelopers.upcoming_events.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.zoodevelopers.upcoming_events.exceptions.FireBaseNotFoundException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class ConectFirebase {
    public static Firestore db;

    public static void connectFirebase() throws IOException {
        try {
            FileInputStream connecting = new FileInputStream("upcominevents.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("CONNECTED");
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception ------------------------------" + e);
        }
    }
}
 */