package com.groupfourtysix.group46_apbn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountFileHandler extends ObjectOutputStream{
    public AccountFileHandler(OutputStream out) throws IOException{
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
                oos = new AccountFileHandler(fos);
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

    public static List<Account> readFile(String filename){
        List<Account> accounts = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Account obj =(Account) ois.readObject();
                    accounts.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist: " + filename);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
