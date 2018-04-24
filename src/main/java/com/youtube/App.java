package com.youtube;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/***
 * Jump-Starting Lambda Programming
 */
public class App {

    public static void main(String[] args) {
        System.out.println("\nDrivers:");
        robocallEligibleDrivers();
        System.out.println("\nVoters:");
        robocallEligibleVoters();
        System.out.println("\nDrinkers:");
        robocallEligibleDrinkers();
        System.out.println("\nEligible Pilots:");
        robocallEligiblePilots();
        System.out.println("\nEligible For Selective Service:");
        robocallEligibleForSelectiveService();
    }

    private static void robocallEligibleDrivers() {
        //robocallPeople(16, Integer.MAX_VALUE);
        robocallPeople(p -> p.getAge() >= 16);
    }

    private static void robocallEligibleVoters() {
        //robocallPeople(18, Integer.MAX_VALUE);
        robocallPeople(p -> p.getAge() >= 18);
    }

    private static void robocallEligibleDrinkers() {
        //robocallPeople(21, Integer.MAX_VALUE);
        robocallPeople(p -> p.getAge() >= 21);
    }

    private static void robocallEligiblePilots() {
        //robocallPeople(23, 65);
        robocallPeople(p -> p.getAge() >= 23 && p.getAge() < 65);
    }

    private static void robocallEligibleForSelectiveService() {
        //robocallPeople(23, 65);
        robocallPeople(p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getSex() == Sex.MALE);
    }

    private static void robocallPeople(Predicate<Person> pred) {
        gatherPersons().stream().filter(pred).forEach(App::robocall);
    }

    @Deprecated
    private static void robocallPeople(int low, int high) {
        List<Person> list = gatherPersons();
        for (Person p : list) {
            if (p.getAge() >= low && p.getAge() <= high) {
                robocall(p);
            }
        }
    }

    @Deprecated
    private static void robocallMatchingPersons(Predicate<Person> pred) {
        List<Person> list = gatherPersons();
        for (Person p : list) {
            if (pred.test(p)) {
                robocall(p);
            }
        }
    }

    //Common Methods
    private static void robocall(Person person) {
        System.out.println(String.format("Robocalling person with age: %d... ", person.getAge()));
    }

    private static List<Person> gatherPersons() {

        return Arrays.asList(
                new Person(15, Sex.MALE, null, null, null, null),
                new Person(16, Sex.FEMALE, null, null, null, null),
                new Person(17, Sex.FEMALE, null, null, null, null),
                new Person(18, Sex.MALE, null, null, null, null),
                new Person(19, Sex.FEMALE, null, null, null, null),
                new Person(20, Sex.FEMALE, null, null, null, null),
                new Person(21, Sex.MALE, null, null, null, null),
                new Person(22, Sex.FEMALE, null, null, null, null),
                new Person(23, Sex.MALE, null, null, null, null),
                new Person(63, Sex.MALE, null, null, null, null),
                new Person(64, Sex.MALE, null, null, null, null),
                new Person(65, Sex.FEMALE, null, null, null, null),
                new Person(66, Sex.FEMALE, null, null, null, null)
        );
    }
}
