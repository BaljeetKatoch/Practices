package com.ref;

import java.util.ArrayList;
import java.util.List;

class Person {
    String personName;
    String emailId;

    public Person(String personName, String emailId) {
        this.personName = personName;
        this.emailId = emailId;
    }
}

public class PersonCollection {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Sandeep", "sandeep@gmail.com"));
        personList.add(new Person("Alex", "alex@gmail.com"));
        personList.add(new Person("Rahul", "rahul@gmail.com"));

        personList.forEach(PersonCollection::printPersonInfo);
    }

    public static void printPersonInfo(Person person) {
        System.out.println("Person Name: " + person.personName);
        System.out.println("Email ID: " + person.emailId);
        System.out.println();
    }
}
