package ir.maktab.partthree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>(Arrays.asList(
                new Person("Priscilla","Wagner"),
                new Person("Tom","Parker"),
                new Person("Elvis","Presley")
        ));

        Comparator<Person> compareByFirstName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };
        Collections.sort(people, compareByFirstName);
        System.out.println("people(sorted by firstname with comprator):\n" + people);

        System.out.println();

        ArrayList<Person2> people2 = new ArrayList<Person2>(Arrays.asList(
                new Person2("Priscilla","Wagner"),
                new Person2("Tom","Parker"),
                new Person2("Elvis","Presley")
        ));
        Collections.sort(people2);
        System.out.println("people2(sorted by lastname with comparable):\n" + people2);


    }
}
