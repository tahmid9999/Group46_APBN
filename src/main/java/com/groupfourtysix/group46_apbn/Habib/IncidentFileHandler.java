package com.groupfourtysix.group46_apbn.Habib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IncidentFileHandler extends ObjectOutputStream {
    public IncidentFileHandler(OutputStream out) throws IOException{
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
                oos = new IncidentFileHandler(fos);
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

    public static List<IncidentLogger> readFile(String filename){
        List<IncidentLogger> incidentLoggers = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    IncidentLogger obj =(IncidentLogger) ois.readObject();
                    incidentLoggers.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException  e) {
            System.out.println("File does not exist: " + filename);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return incidentLoggers;
    }

    // Write updated list of flights to file
    public static void writeFile(List<IncidentLogger> incidentLoggers, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (IncidentLogger f : incidentLoggers) {
                oos.writeObject(f);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
