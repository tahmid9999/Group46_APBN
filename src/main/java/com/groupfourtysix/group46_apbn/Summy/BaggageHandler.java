package com.groupfourtysix.group46_apbn.Summy;


import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import com.groupfourtysix.group46_apbn.Tahmid.PassengerFileHandler;

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

    public static void saveBaggage(BaggageModel baggage, String filename) {
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f, true);
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new BaggageHandler(fos); //
            } else {
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(baggage);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<BaggageModel> readBaggage(String filename) {
        ArrayList<BaggageModel> list = new ArrayList<>();
        File f = new File(filename);
        if (!f.exists()) return list;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof BaggageModel) {
                        list.add((BaggageModel) obj);
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




    public static Passenger readPassengerInfo(String passengerID, String filename) {
        List<Passenger> passengers = PassengerFileHandler.readFile(filename);
        for (Passenger p : passengers) {
            if (p.getPassengerID().equals(passengerID)) return p;
        }
        return null;
    }












}
