/* package org.zoodevelopers.upcoming_events.config;

import java.io.FileInputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zoodevelopers.upcoming_events.exceptions.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        // Ruta al archivo JSON con las credenciales de Firebase
/*         FileInputStream serviceAccount = new FileInputStream("upcominevents.json");
 */     /*    FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build(); */
        // Inicializa FirebaseApp solo si no está ya inicializado
/*         if (FirebaseApp.getApps().isEmpty()) {
/*  */         /*    return FirebaseApp.initializeApp(options);
/*  */       /*  }
        return FirebaseApp.getInstance();
    }
}   */
