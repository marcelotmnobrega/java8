package com.youtube;

import java.util.Objects;

public class Person {

    private int age;
    private Sex sex;
    private PhoneNumber homePhoneNumber;
    private PhoneNumber mobilePhoneNumber;
    private EmailAddr emailAddr;
    private PostalAddr postalAddr;

    public Person() {
    }

    public Person(int age, Sex sex, PhoneNumber homePhoneNumber, PhoneNumber mobilePhoneNumber, EmailAddr emailAddr, PostalAddr postalAddr) {
        this.age = age;
        this.sex = sex;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddr = emailAddr;
        this.postalAddr = postalAddr;
    }

    public int getAge() {
        return age;
    }
    public Sex getSex() {
        return sex;
    }
    public PhoneNumber getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public PhoneNumber getMobilePhoneNumber() {
        return mobilePhoneNumber;
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
                sex == person.sex &&
                Objects.equals(homePhoneNumber, person.homePhoneNumber) &&
                Objects.equals(mobilePhoneNumber, person.mobilePhoneNumber) &&
                Objects.equals(emailAddr, person.emailAddr) &&
                Objects.equals(postalAddr, person.postalAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, homePhoneNumber, mobilePhoneNumber, emailAddr, postalAddr);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", homePhoneNumber=" + homePhoneNumber +
                ", mobilePhoneNumber=" + mobilePhoneNumber +
                ", emailAddr=" + emailAddr +
                ", postalAddr=" + postalAddr +
                '}';
    }
}


