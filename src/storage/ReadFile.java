package storage;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    private final String path = "contacts.csv";
    private static ReadFile instance;
    private ReadFile(){

    }
    public static ReadFile getInstance(){
        if(instance==null){
            instance = new ReadFile();
        }
        return instance;
    }

    public ArrayList<PhoneBook> readFile() throws IOException, ClassNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
            System.out.println("Create new file");
            return new ArrayList<>();
        }
        if(file.canRead()){
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<PhoneBook> phoneBookArrayList = (ArrayList<PhoneBook>) ois.readObject();
            ois.close();
            is.close();
            return phoneBookArrayList;
        }
        System.out.println("read file error");
        return null;
    }

}
