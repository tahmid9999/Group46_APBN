package com.groupfourtysix.group46_apbn.util;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;

public class SessionManager {
    static Passenger loggedInPassenger;

    public static Passenger getLoggedInPassenger() {
        return loggedInPassenger;
    }

    public static void setLoggedInPassenger(Passenger loggedInPassenger) {
        SessionManager.loggedInPassenger = loggedInPassenger;
    }
}
