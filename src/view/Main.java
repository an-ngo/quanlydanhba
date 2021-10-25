package view;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Display.displayMenu();
        }catch (IOException e){
            System.err.println("Error IOException");
            System.err.println(e);
        }
        catch (ClassNotFoundException e){
            System.err.println("Class not found");
            System.out.println(e);
        }
    }
}
