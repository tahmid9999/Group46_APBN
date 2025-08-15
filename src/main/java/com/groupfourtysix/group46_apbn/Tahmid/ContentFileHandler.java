package com.groupfourtysix.group46_apbn.Tahmid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContentFileHandler extends ObjectOutputStream {
    public ContentFileHandler(OutputStream out) throws IOException{
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
                oos = new ContentFileHandler(fos);
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

    public static List<Content> readFile(String filename){
        List<Content> contents = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Content obj =(Content) ois.readObject();
                    contents.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException  e) {
            System.out.println("File does not exist: " + filename);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contents;
    }

    // Write updated list of flights to file
    public static void writeFile(List<Content> contents, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Content f : contents) {
                oos.writeObject(f);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

