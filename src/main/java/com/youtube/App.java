package com.youtube;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args){
        //robocallPersonOlderThan(18);
        System.out.println("\nDrivers:");
        robocallDrivers();
        System.out.println("\nVoters:");
        robocallVoters();
        System.out.println("\nDrinkers:");
        robocallDrinkers();
    }

    private static void robocallDrivers(){
        robocallPersonOlderThan(16);
    }

    private static void robocallVoters(){
        robocallPersonOlderThan(18);
    }

    private static void robocallDrinkers(){
        robocallPersonOlderThan(21);
    }

    private static void robocallPersonOlderThan(int age){
        List<Person> list = gatherPersons();
        for(Person p : list){
            if (p.getAge() >= age) {
                //PhoneNumber num = p.getPhoneNumber();
                //robocall(num);
                robocall(p);
            }
        }
    }

    private static void robocall(Person person) {
        System.out.println(String.format("Robocalling person with age: %d... ", person.getAge()));
    }

    private static List<Person> gatherPersons() {
        return Arrays.asList(
                new Person(15, null, null, null, null),
                new Person(16, null, null, null, null),
                new Person(17, null, null, null, null),
                new Person(18, null, null, null, null),
                new Person(19, null, null, null, null),
                new Person(20, null, null, null, null),
                new Person(21, null, null, null, null),
                new Person(22, null, null, null, null));
    }
}
