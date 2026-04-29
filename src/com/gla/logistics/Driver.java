package com.rajya.logistics;

// Driver class - each driver has a name, ID, and their own route
public class Driver {

    String name;
    String id;
    RouteLinkedList<Checkpoint> route; // Each driver has their own linked list of checkpoints

    public Driver(String name, String id) {
        this.name = name;
        this.id = id;
        this.route = new RouteLinkedList<>(); // Initialize empty route
    }

    // Display basic driver info
    public void displayInfo() {
        System.out.println("  Driver Name : " + name);
        System.out.println("  Driver ID   : " + id);
        System.out.println("  Checkpoints : " + route.getSize());
    }
}
