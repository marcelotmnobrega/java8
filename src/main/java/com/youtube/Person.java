package com.youtube;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(phoneNumber, person.phoneNumber) &&
                Objects.equals(emailAddr, person.emailAddr) &&
                Objects.equals(postalAddr, person.postalAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, phoneNumber, emailAddr, postalAddr);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", phoneNumber=" + phoneNumber +
                ", emailAddr=" + emailAddr +
                ", postalAddr=" + postalAddr +
                '}';
    }
}
