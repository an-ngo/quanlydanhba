package model;

import java.io.Serializable;

public class PhoneBook implements Serializable {
    String name;
    String type;
    String phoneNumber;
    String address;
    String birthday;
    String email;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public PhoneBook(String name, String type, String phoneNumber, String address, String birthday, String email) {
        this.name = name;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}'+"\n";
    }
}
