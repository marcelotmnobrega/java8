package com.youtube;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/***
 * Jump-Starting Lambda Programming
 */
public class App {

    public static void main(String[] args){
        System.out.println("\nDrivers:");
        robocallEligibleDrivers();
        System.out.println("\nVoters:");
        robocallEligibleVoters();
        System.out.println("\nDrinkers:");
        robocallEligibleDrinkers();
        System.out.println("\nEligible Pilots:");
        robocallEligiblePilots();
    }

    private static void robocallEligibleDrivers(){
        //robocallPeople(16, Integer.MAX_VALUE);
        robocallPeople((p) -> checkIfPersonIsEligibleToDrive(p));
    }

    private static void robocallEligibleVoters(){
        //robocallPeople(18, Integer.MAX_VALUE);
        robocallPeople((p) -> checkIfPersonIsEligibleToVote(p));
    }

    private static void robocallEligibleDrinkers(){
        //robocallPeople(21, Integer.MAX_VALUE);
        robocallPeople((p) -> checkIfPersonIsEligibleToDrink(p));
    }

    private static void robocallEligiblePilots(){
        //robocallPeople(23, 65);
        robocallPeople((p) -> checkIfPersonIsEligibleToPilot(p));
    }

    private static void robocallPeople(int low, int high){
        List<Person> list = gatherPersons();
        for(Person p : list){
            if (p.getAge() >= low && p.getAge() <= high){
                robocall(p);
            }
        }
    }

    private static void robocallMatchingPersons(Predicate<Person> pred){
        List<Person> list = gatherPersons();
        for(Person p : list){
            if (pred.test(p)){
                robocall(p);
            }
        }
    }

    private static void robocallPeople(Predicate<Person> p){
        gatherPersons().stream().filter(p).forEach(App::robocall);
    }

    //Predicates
    private static boolean checkIfPersonIsEligibleToDrive(Person person){
        return person.getAge() >= 16;
    }
    private static boolean checkIfPersonIsEligibleToVote(Person person){
        return person.getAge() >= 18;
    }
    private static boolean checkIfPersonIsEligibleToDrink(Person person){
        return person.getAge() >= 21;
    }
    private static boolean checkIfPersonIsEligibleToPilot(Person person){
        return person.getAge() >= 23 && person.getAge() < 65;
    }
    private static boolean checkIfPersonIsEligibleForSelectiveService(Person person){
        return person.getAge() >= 18 && person.getAge() <= 25 && person.getSex() == Sex.MALE;
    }

    //Common Methods
    private static void robocall(Person person) {
        System.out.println(String.format("Robocalling person with age: %d... ", person.getAge()));
    }

    private static List<Person> gatherPersons() {

        return Arrays.asList(
                new Person(15, Sex.MALE, null, null, null),
                new Person(16, Sex.FEMALE, null, null, null),
                new Person(17, Sex.FEMALE, null, null, null),
                new Person(18, Sex.MALE, null, null, null),
                new Person(19, Sex.FEMALE, null, null, null),
                new Person(20, Sex.FEMALE, null, null, null),
                new Person(21, Sex.MALE, null, null, null),
                new Person(22, Sex.FEMALE, null, null, null),
                new Person(23, Sex.MALE, null, null, null),
                new Person(63, Sex.MALE, null, null, null),
                new Person(64, Sex.MALE, null, null, null),
                new Person(65, Sex.FEMALE, null, null, null),
                new Person(66, Sex.FEMALE, null, null, null)
                );
    }
}
