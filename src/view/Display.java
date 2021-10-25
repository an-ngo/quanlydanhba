package view;

import controller.PhoneBookManager;
import model.PhoneBook;
import storage.ReadFile;
import storage.WriteFile;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Display {
    static PhoneBookManager phoneBookManager = new PhoneBookManager();
    static String phoneNumberRegex = "^[0-9]{9,12}$";
    static String emailRegex = "^[\\w]+@[\\w\\.]+[\\w]";
    public static void displayMenu() throws IOException, ClassNotFoundException {
        System.out.println("-----------------------------------------");
        System.out.println("Chon chuc nang theo so (de tiep tuc)");
        System.out.println("1: Xem danh sach");
        System.out.println("2: Them moi");
        System.out.println("3: Cap nhat");
        System.out.println("4: Xoa");
        System.out.println("5: Tim kiem");
        System.out.println("6: Doc tu file");
        System.out.println("7: Ghi vao file");
        System.out.println("8: Thoat");
        System.out.println("Chon chuc nang");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                display1Show();
                break;
            case "2":
                display2Add();
                break;
            case "3":
                display3Update();
                break;
            case "4":
                display4Delete();
                break;
            case "5":
                display5Find();
                break;
            case "6":
                display6ReadFromFile();
                break;
            case "7":
                display7WriteToFile();
                break;
            case "8":
                System.exit(0);
            default:
                System.out.println("Wrong input, please input again");
                displayMenu();
        }
                displayMenu();
    }

    public static void display1Show(){
        //System.out.println("Them moi");
        System.out.println(phoneBookManager.toString());
    }
    public static void display2Add(){
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);

        System.out.println("Nhap vao :");
        System.out.println("phoneNumber: ");
        String phoneNumber = scannerLine.nextLine();
        if(!checkRegex(phoneNumberRegex,phoneNumber)){
            return;
        }

        System.out.println("Type: ");
        String type = scannerLine.nextLine();
        System.out.println("Name: ");
        String name = scannerLine.nextLine();
        System.out.println("Gender: ");
        String gender = scannerLine.nextLine();
        System.out.println("Address: ");
        String address = scannerLine.nextLine();
        System.out.println("Birthday: ");
        String birthday = scannerLine.nextLine();
        System.out.println("Email: ");
        String email = scannerLine.nextLine();
        if(!checkRegex(emailRegex,email)){
            return;
        }
        PhoneBook p = new PhoneBook(name,type,phoneNumber,address,birthday,email);
        phoneBookManager.addPhoneBook(p);
        System.out.println("Add Success");
    }

    public static void display3Update(){
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Input phone number to fix: ");
        String phoneNumber = scannerLine.nextLine();
        if(phoneNumber==null){
            return;
        }
        PhoneBook p = phoneBookManager.findPhoneBookByPhoneNumber(phoneNumber);
        if (p == null) {
            System.out.println("Phone number Not found, input again");
            display3Update();
            return;
        }
        System.out.println("Nhap vao :");
        System.out.println("phoneNumber: ");
        String phoneNumber1 = scannerLine.nextLine();
        System.out.println("Type: ");
        String type = scannerLine.nextLine();
        System.out.println("Name: ");
        String name = scannerLine.nextLine();
        System.out.println("Gender: ");
        String gender = scannerLine.nextLine();
        System.out.println("Address: ");
        String address = scannerLine.nextLine();
        System.out.println("Birthday: ");
        String birthday = scannerLine.nextLine();
        System.out.println("Email: ");
        String email = scannerLine.nextLine();
        PhoneBook p1 = new PhoneBook(name,type,phoneNumber,address,birthday,email);
        phoneBookManager.updatePhoneBook(p1,p);
        System.out.println("Update success");
    }

    public static void display4Delete(){
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Input phone number to delete: ");
        String phoneNumber = scannerLine.nextLine();
        if(phoneNumber==null){
            return;
        }
        PhoneBook p = phoneBookManager.findPhoneBookByPhoneNumber(phoneNumber);
        if (p == null) {
            System.out.println("Phone number Not found, input again");
            display4Delete();
            return;
        }
        System.out.println("Are you sure to delete this PhoneNumber?");
        String y = scannerLine.nextLine();
        if(y.equals("Y") || y.equals("y")){
            phoneBookManager.deletePhoneBookByPhoneNumber(phoneNumber);
            System.out.println("Delete success");
            return;
        }
        System.out.println("Not delete yet");
    }

    public static void display5Find(){
        display1Show();
        System.out.println("Input your choice");
        System.out.println("1: Find by phoneNumber");
        System.out.println("2: Find by Name");
        Scanner scannerLine = new Scanner(System.in);
        String input = scannerLine.nextLine();
        switch (input){
            case "1":
                System.out.println("Input phoneNumber:");
                String phoneNumber = scannerLine.nextLine();
                PhoneBook p1 = phoneBookManager.findPhoneBookByPhoneNumber(phoneNumber);
                System.out.println(p1);
                break;
            case "2":
                System.out.println("Input Name");
                String name = scannerLine.nextLine();
                PhoneBook p2 = phoneBookManager.findPhoneBookByName(name);
                System.out.println(p2);
                break;
            default:
                System.out.println("wrong input");
        }
    }

    public static void display6ReadFromFile() throws IOException, ClassNotFoundException {
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("This function will delete all data, input y to continue");
        String y = scannerLine.nextLine();
        if(y.equals("Y") || y.equals("y")){
            ReadFile readFile = ReadFile.getInstance();
            phoneBookManager.setPhoneBookArrayList(readFile.readFile());
            return;
        }
        System.out.println("Not read file yet");
    }
    public static void display7WriteToFile() throws IOException {
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Do you want to write, input y to continue");
        String y = scannerLine.nextLine();
        if (y.equals("Y") || y.equals("y")) {
            WriteFile writeFile = WriteFile.getInstance();
            writeFile.writeFile(phoneBookManager);
        }
    }

    public static boolean checkRegex(String regex,String check){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(check);
        if(!matcher.matches()){
            System.out.println("Input not valid");
            return false;
        }
        return true;
    }
}
