package com.groupfourtysix.group46_apbn.Summy;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;

import java.io.*;
import java.util.ArrayList;

public class BoardingPassengerHandler extends ObjectOutputStream {
    public BoardingPassengerHandler(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {
        reset();
    }

    public static void savePassenger(Passenger passenger, String filename) {
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f, true);
            ObjectOutputStream oos;

            if (f.exists() && f.length() > 0) {
                oos = new BoardingPassengerHandler(fos); // append without writing header
            } else {
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(passenger);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Passenger> readPassengers(String filename) {
        ArrayList<Passenger> list = new ArrayList<>();
        File f = new File(filename);
        if (!f.exists()) return list;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Passenger) {
                        list.add((Passenger) obj);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Passenger readPassengerById(String passengerID, String filename) {
        ArrayList<Passenger> passengers = readPassengers(filename);
        for (Passenger p : passengers) {
            if (p.getPassengerID().equals(passengerID)) return p;
        }
        return null;
    }


    public static void updatePassenger(Passenger updatedPassenger, String filename) {
        ArrayList<Passenger> passengers = readPassengers(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Passenger p : passengers) {
                if (p.getPassengerID().equals(updatedPassenger.getPassengerID())) {
                    oos.writeObject(updatedPassenger);
                } else {
                    oos.writeObject(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deletePassenger(String passengerID, String filename) {
        ArrayList<Passenger> passengers = readPassengers(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Passenger p : passengers) {
                if (!p.getPassengerID().equals(passengerID)) {
                    oos.writeObject(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }










}
