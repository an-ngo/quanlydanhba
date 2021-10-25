package storage;

import controller.PhoneBookManager;
import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;

public class WriteFile {
    private final String path = "contacts.csv";
    private static WriteFile instance;
    private WriteFile(){

    }
    public static WriteFile getInstance(){
        if(instance==null){
            instance = new WriteFile();
        }
        return instance;
    }

    public void writeFile(PhoneBookManager phoneBookManager) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
            System.out.println("Create new file");
        }
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(phoneBookManager.getPhoneBookArrayList());
        oos.close();
        os.close();
    }
}
