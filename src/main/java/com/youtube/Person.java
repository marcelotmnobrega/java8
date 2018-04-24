package com.youtube;

import java.util.Arrays;
import java.util.List;

//Jump-Starting Lambda Programming

public class Person {
    private int age;
    private Sex sex;
    private PhoneNumber phoneNumber;
    private EmailAddr emailAddr;
    private PostalAddr postalAddr;

    public Person() {
    }

    public Person(int age, Sex sex, PhoneNumber phoneNumber, EmailAddr emailAddr, PostalAddr postalAddr) {
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.emailAddr = emailAddr;
        this.postalAddr = postalAddr;
    }

    void robocallEveryPerson(){
        List<Person> list = gatherPersons();
        for(Person p : list){
            if (p.getAge() >= 16) {
                PhoneNumber num = p.getPhoneNumber();
                robocall(num);
            }
        }
    }

    private List<Person> gatherPersons() {
        return Arrays.asList(new Person());
    }

    private void robocall(PhoneNumber num) {
        System.out.println(String.format("robocalling $1... ", num));
    }

    public int getAge() {
        return age;
    }
    public Sex getSex() {
        return sex;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public EmailAddr getEmailAddr() {
        return emailAddr;
    }
    public PostalAddr getPostalAddr() {
        return postalAddr;
    }
}
