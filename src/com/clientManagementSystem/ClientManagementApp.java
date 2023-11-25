package com.clientManagementSystem;

import com.clientMaagementSystem.fileHandling.CSVReader;
import com.clientMaagementSystem.fileHandling.CSVWriter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Implement file operations for XML/SQLite
        CSVReader fileReader = new CSVReader();
        CSVWriter fileWriter = new CSVWriter();
        List<Serializable> clients = new ArrayList<>();
        Service service = new Service(fileReader, fileWriter, clients);
        Manager manager = new Manager(service);
        System.out.println("Welcome to the Client Management System");
        displayOptions();

        boolean active = true;
        while (active) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("Save & Exit")) {
                active = false;
            } else {
                manager.performAction(command);
            }
            // Add Client
            // 1, Oceanic Enterprises, Finance, Sarah Smith, 500000.00
            // Update Client
            // 1, Oceanic Enterprises, Tech, Sarah Smith, 750000.00
            // View Clients
            // Search Industry Tech
            // Search ID 1
            // Remove Client 1
            // Search Name Oceanic
            // Save &amp; Exit
        }
    }

    private static void displayOptions() {
        System.out.println("Add Client");
        System.out.println("Update Client");
        System.out.println("View Clients");
        System.out.println("Search by Industry");
        System.out.println("Search by ID");
        System.out.println("Search by Client");
        System.out.println("Search by Name");
        System.out.println("Save & Exit");
    }
}
