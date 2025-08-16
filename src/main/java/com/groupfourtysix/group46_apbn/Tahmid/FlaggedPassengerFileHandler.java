package com.groupfourtysix.group46_apbn.Tahmid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlaggedPassengerFileHandler extends ObjectOutputStream {
    public FlaggedPassengerFileHandler(OutputStream out) throws IOException{
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }

    public static void createFile(Object data, String filename){
        try{
            File f = new File(filename);
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()){
                fos = new FileOutputStream(f, true);
//                Changing statement
                oos = new FlaggedPassengerFileHandler(fos);
            }else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

//            Write Stream & close
            oos.writeObject(data);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Passenger> readFile(String filename){
        ArrayList<Passenger> flaggedPassengers = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Passenger obj =(Passenger) ois.readObject();
                    flaggedPassengers.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException  e) {
            System.out.println("File does not exist: " + filename);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flaggedPassengers;
    }

    // Write updated list of flights to file
    public static void writeFile(ArrayList<Passenger> flaggedPassengers, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Passenger f : flaggedPassengers) {
                oos.writeObject(f);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
