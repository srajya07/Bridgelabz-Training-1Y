package com.rajya.logistics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 static ArrayList<Driver> driverList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("     LOGISTICS ROUTE TRACKER SYSTEM");
        System.out.println("==============================================");

        int choice = -1;

        while (choice != 0) {
            printMainMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addDriver();
                    break;
                case 2:
                    viewAllDrivers();
                    break;
                case 3:
                    addCheckpointMenu();
                    break;
                case 4:
                    viewRouteMenu();
                    break;
                case 5:
                    removeCheckpointMenu();
                    break;
                case 6:
                    findCheckpointMenu();
                    break;
                case 7:
                    routeStatsMenu();
                    break;
                case 0:
                    System.out.println("\nExiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // MAIN MENU DISPLAY
    static void printMainMenu() {
        System.out.println("\n----------------------------------------------");
        System.out.println("                  MAIN MENU");
        System.out.println("----------------------------------------------");
        System.out.println("  1. Add a new Driver");
        System.out.println("  2. View all Drivers");
        System.out.println("  3. Add Checkpoint to a Driver's Route");
        System.out.println("  4. View Driver's Route");
        System.out.println("  5. Remove a Checkpoint");
        System.out.println("  6. Find a Checkpoint by ID");
        System.out.println("  7. Route Statistics & Score");
        System.out.println("  0. Exit");
        System.out.println("----------------------------------------------");
    }
    // 1. ADD DRIVER
    static void addDriver() {
        System.out.println("\n--- Add New Driver ---");
        System.out.print("Enter Driver Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Driver ID  : ");
        String id = sc.nextLine().trim();

        // Check if driver ID already exists
        for (Driver d : driverList) {
            if (d.id.equals(id)) {
                System.out.println("Driver with ID [" + id + "] already exists!");
                return;
            }
        }

        Driver newDriver = new Driver(name, id);
        driverList.add(newDriver);
        System.out.println("Driver [" + name + "] added successfully!");
    }
    // 2. VIEW ALL DRIVERS
    static void viewAllDrivers() {
        System.out.println("\n--- All Drivers ---");
        if (driverList.isEmpty()) {
            System.out.println("No drivers found. Please add a driver first.");
            return;
        }
        for (int i = 0; i < driverList.size(); i++) {
            // Wrapper class usage: Integer.toString() to convert int to String
            System.out.println("\n  [" + Integer.toString(i + 1) + "]");
            driverList.get(i).displayInfo();
        }
    }
    // 3. ADD CHECKPOINT TO A DRIVER
    static void addCheckpointMenu() {
        System.out.println("\n--- Add Checkpoint to Route ---");

        Driver driver = selectDriver();
        if (driver == null) return;

        System.out.println("\nSelect Checkpoint Type:");
        System.out.println("  1. Delivery Checkpoint");
        System.out.println("  2. Fuel Checkpoint");
        System.out.println("  3. Rest Checkpoint");
        int typeChoice = readInt("Enter type: ");

        System.out.print("Enter Checkpoint ID       : ");
        String cpId = sc.nextLine().trim();

        // Check for duplicate checkpoint ID in this driver's route
        if (driver.route.findCheckpoint(cpId) != null) {
            System.out.println("Checkpoint with ID [" + cpId + "] already exists in this route!");
            return;
        }

        System.out.print("Enter Location            : ");
        String loc = sc.nextLine().trim();

        // Using Double wrapper class to store input
        Double distance = readDouble("Enter Distance from prev (km): ");
        Integer expectedTime = readInt("Enter Expected Time (min)    : ");
        Integer actualTime = readInt("Enter Actual Time (min)      : ");

        // Create the right checkpoint object based on user's choice
        Checkpoint cp;
        switch (typeChoice) {
            case 1:
                cp = new Delivery(cpId, loc, distance, expectedTime, actualTime);
                break;
            case 2:
                cp = new FuelCheckpoint(cpId, loc, distance, expectedTime, actualTime);
                break;
            case 3:
                cp = new RestCheckpoint(cpId, loc, distance, expectedTime, actualTime);
                break;
            default:
                System.out.println("Invalid type selected.");
                return;
        }

        driver.route.addCheckpoint(cp);

        // Show delay status after adding
        if (cp.delayedcheck()) {
            System.out.println("Note: This checkpoint is DELAYED by " +
                    (cp.actual_time - cp.expected_time) + " minutes. Penalty = " + cp.Penality());
        } else {
            System.out.println("On time! No penalty.");
        }
    }
    // 4. VIEW A DRIVER'S FULL ROUTE
    static void viewRouteMenu() {
        System.out.println("\n--- View Driver Route ---");

        Driver driver = selectDriver();
        if (driver == null) return;

        System.out.println("\n  Route for Driver: " + driver.name + " [" + driver.id + "]");
        driver.route.printRoute();
    }
    // 5. REMOVE A CHECKPOINT
    static void removeCheckpointMenu() {
        System.out.println("\n--- Remove Checkpoint ---");

        Driver driver = selectDriver();
        if (driver == null) return;

        System.out.print("Enter Checkpoint ID to remove: ");
        String cpId = sc.nextLine().trim();

        boolean removed = driver.route.removeCheckpoint(cpId);
        if (removed) {
            System.out.println("Checking route consistency after removal...");
            if (!driver.route.isConsistent()) {
                System.out.println("WARNING: Route is now INCONSISTENT! Missing Delivery or Fuel checkpoint.");
            } else {
                System.out.println("Route is still consistent.");
            }
        }
    }
    // 6. FIND A CHECKPOINT BY ID
    static void findCheckpointMenu() {
        System.out.println("\n--- Find Checkpoint ---");

        Driver driver = selectDriver();
        if (driver == null) return;

        System.out.print("Enter Checkpoint ID to find: ");
        String cpId = sc.nextLine().trim();

        Checkpoint cp = driver.route.findCheckpoint(cpId);
        if (cp == null) {
            System.out.println("Checkpoint [" + cpId + "] not found.");
        } else {
            System.out.println("\n  Found Checkpoint:");
            System.out.println("  ID        : " + cp.id);
            System.out.println("  Location  : " + cp.location);
            System.out.println("  Type      : " + cp.getType());
            System.out.println("  Critical  : " + cp.isCritical());
            System.out.println("  Distance  : " + cp.distance + " km");
            System.out.println("  Expected  : " + cp.expected_time + " min");
            System.out.println("  Actual    : " + cp.actual_time + " min");
            System.out.println("  Delayed   : " + cp.delayedcheck());
            System.out.println("  Penalty   : " + cp.Penality());
        }
    }
    // 7. ROUTE STATISTICS
    static void routeStatsMenu() {
        System.out.println("\n--- Route Statistics ---");

        Driver driver = selectDriver();
        if (driver == null) return;

        System.out.println("\n  Statistics for Driver: " + driver.name);
        // Using Double wrapper class for total values
        Double totalDist = driver.route.computeTotalDistance();
        Double totalPenalty = driver.route.computeTotalPenalty();
        Double routeScore = driver.route.computeRouteScore();

        System.out.println("  Total Distance  : " + totalDist + " km");
        System.out.println("  Total Penalty   : " + totalPenalty);
        System.out.println("  Route Score     : " + routeScore + "  (Distance - Penalty)");
        System.out.println("  Consistent      : " + (driver.route.isConsistent() ? "YES" : "NO"));
        System.out.println("  Checkpoints     : " + driver.route.getSize());
    }
    static Driver selectDriver() {
        if (driverList.isEmpty()) {
            System.out.println("No drivers available. Please add a driver first.");
            return null;
        }

        System.out.println("\nAvailable Drivers:");
        for (int i = 0; i < driverList.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + driverList.get(i).name +
                    " [ID: " + driverList.get(i).id + "]");
        }

        int choice = readInt("Select driver number: ");
        if (choice < 1 || choice > driverList.size()) {
            System.out.println("Invalid selection.");
            return null;
        }

        return driverList.get(choice - 1);
    }
    static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                return Integer.parseInt(input); // Wrapper class: Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
    static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                return Double.parseDouble(input); // Wrapper class: Double
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
            }
        }
    }
}
