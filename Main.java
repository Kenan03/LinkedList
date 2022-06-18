package com.company;
// if "true" we can to add reply numbers
public class Main {

    public static void main(String[] args) {
	SortedIntegerList a = new SortedIntegerList(true);
    a.add(1);
    a.add(2);
    a.add(5);
    a.add(6);
    a.add(7);
    System.out.println(a.toString());

    SortedIntegerList r = new SortedIntegerList(false);
    r.add(1);
    r.add(2);
    r.add(1);
    r.add(5);
    r.add(6);
    System.out.println(r.toString());

    System.out.println(a.minus(r));

    System.out.println(a.equals(r));
    }
}
