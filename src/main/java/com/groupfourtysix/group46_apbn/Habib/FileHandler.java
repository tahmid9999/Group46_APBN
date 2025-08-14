package com.groupfourtysix.group46_apbn.Habib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler extends ObjectOutputStream {
    public FileHandler(OutputStream out) throws IOException{
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
                oos = new FileHandler(fos);
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

    public static List<Flight> readFile(String filename){
        List<Flight> flights = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Flight obj =(Flight) ois.readObject();
                    flights.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException  e) {
            System.out.println("File does not exist: " + filename);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flights;
    }

    // Write updated list of flights to file
    public static void writeFile(List<Flight> flights, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Flight f : flights) {
                oos.writeObject(f);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
