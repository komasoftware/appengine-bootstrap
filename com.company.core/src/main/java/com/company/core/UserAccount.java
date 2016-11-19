package com.company.core;

import com.google.api.server.spi.auth.common.User;
import com.google.firebase.auth.FirebaseToken;

/**
 * This class manages the user account of the app
 */
public class UserAccount extends User {
    private FirebaseToken firebaseToken;

    /**
     * Constructs this object
     *
     * @param email the user email address
     */
    public UserAccount(String email) {
        super(email);
    }

    /**
     * Constructs this object
     *
     * @param id    the user id
     * @param email the user email address
     */
    public UserAccount(String id, String email) {
        super(id, email);
    }

    /**
     * Constructs this object
     *
     * @param firebaseToken the Firebase token
     */
    public UserAccount(FirebaseToken firebaseToken) {
        super(firebaseToken.getUid(), firebaseToken.getEmail());
        this.firebaseToken = firebaseToken;
    }

    /**
     * Gets the {@link FirebaseToken}
     *
     * @return the Firebase token
     */
    public FirebaseToken getFirebaseToken() {
        return firebaseToken;
    }

    /**
     * Sets the {@link FirebaseToken}
     *
     * @param firebaseToken the Firebase token
     */
    public void setFirebaseToken(FirebaseToken firebaseToken) {
        this.firebaseToken = firebaseToken;
    }
}
