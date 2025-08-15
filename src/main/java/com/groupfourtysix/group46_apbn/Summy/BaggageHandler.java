package com.groupfourtysix.group46_apbn.Summy;


import com.groupfourtysix.group46_apbn.Tahmid.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaggageHandler extends ObjectOutputStream {


    public BaggageHandler(OutputStream out) throws IOException{
        super(out);
    }


    protected void writeStreamHeader() throws IOException {
        reset();
    }

    public static void createFile(String[] data, String filename) {
        try {
            File f = new File(filename);
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new BaggageHandler(fos); //
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(data);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String[]> readFile(String filename) {
        List<String[]> records = new ArrayList<>();
        File f = new File(filename);

        if (!f.exists()) {
            return records;
        }

        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof String[]) {
                        records.add((String[]) obj);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return records;
    }




    public static Passenger findPassengerById(String passengerID) {
        for (Passenger p : Passenger.passengerArrayList) {
            if (p.getPassengerID().equals(passengerID)) {
                return p;
            }
        }
        return null;
    }












}
