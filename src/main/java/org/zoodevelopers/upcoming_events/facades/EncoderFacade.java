package org.zoodevelopers.upcoming_events.facades;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.zoodevelopers.upcoming_events.facades.encryptations.Base64Encoder;
import org.zoodevelopers.upcoming_events.implementations.events.IEncryptFacade;

@Component
public class EncoderFacade implements IEncryptFacade {

    PasswordEncoder bCryptPasswordEncoder;
    Base64Encoder base64Encoder;

    public EncoderFacade(PasswordEncoder bCryptPasswordEncoder, Base64Encoder base64Encoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.base64Encoder = base64Encoder;
    }

    @Override
    public String encode(String type, String data) {
        String dataEncrypted = "";

        if ("bcrypt".equals(type)) {
            dataEncrypted = bCryptPasswordEncoder.encode(data);
        }
        if ("base64".equals(type)) {
            dataEncrypted = base64Encoder.encode(data);
        }

        return dataEncrypted;
    }

    @Override
    public String decode(String type, String data) {
        String dataDecoded = "";

        if ("base64".equals(type)) {
            dataDecoded = base64Encoder.decode(data);
        }

        return dataDecoded;
    }

}
