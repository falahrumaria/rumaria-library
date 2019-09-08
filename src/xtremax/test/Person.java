package xtremax.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E460 on 06/03/2018.
 */
public class Person {

    private String name;
    private List<Person> friends = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void makeFriend(Person newFriend) {
        if (!this.friends.contains(newFriend)) {
            this.friends.add(newFriend);
            newFriend.getFriends().add(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return this.friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
}
