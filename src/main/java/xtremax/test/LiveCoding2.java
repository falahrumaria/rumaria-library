package xtremax.test;

import java.util.*;

/**
 * Created by E460 on 06/03/2018.
 */
public class LiveCoding2 {

    private static List<Person> personList;
    private static int ctr;

    /**
     * In a community have a method to spread the information to the entire member, every member will contact his all his
     * friend to distribute the information. it will take about 1 day for each person to process the information and tell the other friend.
     * Q1: how much minimum time needed to spread the information to entire member?
     * Q2: how much minimum time needed to spread the information to entire member if every member has limited the person that he can tell?
     * Note: The order to spread the information follows the friend order. Prioritize the one who didn't get information first.
     */
    public static void main(String[] args) {
        generateFriendNetwork();
        Person personA = getCurrentPerson("Person A");
        Person personD = getCurrentPerson("Person D");
        Person personF = getCurrentPerson("Person F");

        int minimumDays = findMinimumDays(personA);
        System.out.println("Minimum number of Days: " + minimumDays);

        int minimumDays1 = findMinimumDays(personA, 1);
        System.out.println("Minimum number of Days (special case): " + minimumDays1);
    }

    public static int findMinimumDays(Person a) {
        //***** CODES - Amend Codes below this segment ******
        ctr = 0;
        Map<Person, Boolean> map = new HashMap<>();
        for (Person person : personList) {
            map.put(person, false);
        }
        map.put(a, true);
        doIt(a, map);
        return ctr;
        //***** CODES - Amend Codes above this segment ******
    }

    private static void doIt(Person a, Map<Person, Boolean> map) {
        if (a.getFriends().isEmpty() || checkAllInformed(map)) {
            return;
        }
        for (Person person : a.getFriends()) {
            map.put(person, true);
        }
        ctr++;
    }

    private static boolean checkAllInformed(Map<Person, Boolean> map) {
        for (Person person : map.keySet()) {
            if (!map.get(person)) {
                return false;
            }
        }
        return true;
    }

    public static int findMinimumDays(Person a, int maxInfo) {
        //***** CODES - Amend Codes below this segment ******
        ctr = 0;
        return 0;
        //***** CODES - Amend Codes above this segment ******
    }

    public static void generateFriendNetwork() {
        personList = new ArrayList<>();

        Person personA = new Person("Person A");
        Person personB = new Person("Person B");
        Person personC = new Person("Person C");
        Person personD = new Person("Person D");
        Person personE = new Person("Person E");
        Person personF = new Person("Person F");

        personList.add(personA);
        personList.add(personB);
        personList.add(personC);
        personList.add(personD);
        personList.add(personE);
        personList.add(personF);

        personA.makeFriend(personB);
        personA.makeFriend(personE);
        personB.makeFriend(personC);
        personB.makeFriend(personF);
        personC.makeFriend(personF);
        personC.makeFriend(personD);
        personD.makeFriend(personE);
    }

    // ganti person.equals to person.getName().equals
    public static Person getCurrentPerson(String name) {
        ListIterator<Person> iterator = personList.listIterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}

