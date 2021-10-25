package controller;

import model.PhoneBook;

import java.io.Serializable;
import java.util.ArrayList;

public class PhoneBookManager implements Serializable {
    private ArrayList<PhoneBook> phoneBookArrayList = new ArrayList<>();

    public ArrayList<PhoneBook> getPhoneBookArrayList() {
        return phoneBookArrayList;
    }

    public PhoneBookManager() {
    }

    @Override
    public String toString() {
//        return "PhoneBookManager{" +
//                "phoneBookArrayList=" + phoneBookArrayList +
//                '}';
        String s="";
        for (PhoneBook p :
                phoneBookArrayList) {
            s+=p.toString()+"\n";
        }
        return s;
    }

    public void setPhoneBookArrayList(ArrayList<PhoneBook> phoneBookArrayList) {
        this.phoneBookArrayList = phoneBookArrayList;
    }

    public PhoneBookManager(ArrayList<PhoneBook> phoneBookArrayList) {
        this.phoneBookArrayList = phoneBookArrayList;
    }
    public void addPhoneBook(PhoneBook phoneBook){
        phoneBookArrayList.add(phoneBook);
    }
    public void updatePhoneBook(PhoneBook p1, PhoneBook phoneBook){
        for (int i = 0; i < phoneBookArrayList.size(); i++) {
            PhoneBook p = phoneBookArrayList.get(i);
            if(p.equals(phoneBook)){
                phoneBookArrayList.remove(i);
                phoneBookArrayList.add(i,p1);
                return;
            }
        }
        System.out.println("error update");
    }

    public void removePhoneBook(int index){
        phoneBookArrayList.remove(index);
    }

    public PhoneBook findPhoneBookByIndex(int index){
        return phoneBookArrayList.get(index);
    }

    public PhoneBook findPhoneBookByPhoneNumber(String phoneNumber){
        for (PhoneBook p :
                phoneBookArrayList) {
            if (phoneNumber.equals(p.getPhoneNumber())) {
                return p;
            }
        }
        return null;
    }
    public PhoneBook findPhoneBookByName(String name){
        for (PhoneBook p :
                phoneBookArrayList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }


    public void deletePhoneBookByPhoneNumber(String pn){
        phoneBookArrayList.removeIf(p -> pn.equals(p.getPhoneNumber()));
    }
}
