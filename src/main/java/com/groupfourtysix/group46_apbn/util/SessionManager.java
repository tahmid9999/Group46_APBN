package com.groupfourtysix.group46_apbn.util;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;

public class SessionManager {
//    static Passenger loggedInPassenger;
    private static AccountSession accountSession = new AccountSession();
    private static PassengerSession passengerSession = new PassengerSession();

    public static PassengerSession getPassengerSession() {
        return passengerSession;
    }

    public static AccountSession getAccountSession() {
        return accountSession;
    }

//    public static Passenger getLoggedInPassenger() {
//        return loggedInPassenger;
//    }
//
//    public static void setLoggedInPassenger(Passenger loggedInPassenger) {
//        SessionManager.loggedInPassenger = loggedInPassenger;
//    }
}
