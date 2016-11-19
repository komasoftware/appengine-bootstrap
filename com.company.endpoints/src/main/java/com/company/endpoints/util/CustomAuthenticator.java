package com.company.endpoints.util;

import com.company.core.UserAccount;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Authenticator;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.logging.Logger;

public class CustomAuthenticator implements Authenticator {
    private static final Logger LOG = Logger.getLogger(CustomAuthenticator.class.getName());
    private static final String COOKIE_FIREBASE_TOKEN = "firebase_token";

    static {
        LOG.info("CustomAuthenticator: initializing");
        InputStream serviceAccountResourceStream = CustomAuthenticator.class.getResourceAsStream("/serviceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(serviceAccountResourceStream)
                .build();

        FirebaseApp.initializeApp(options);
        LOG.info("CustomAuthenticator: initialized");
    }

    @Override
    public User authenticate(HttpServletRequest httpServletRequest) {
        UserAccount userAccount = null;
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals(COOKIE_FIREBASE_TOKEN)) {
                    FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(cookie.getValue()).getResult();
                    userAccount = new UserAccount(firebaseToken);
                }
            }
        }
        return userAccount;
    }
}