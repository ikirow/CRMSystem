package com.clientManagementSystem;

import java.util.Scanner;

public class ClientManagementApp {
    public static void main(String[] args) {
        // Implement file operations for XML/SQLite
        Service service = new ClientService(fileReader, fileWriter);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        displayOptions();
        boolean active = true;
        while (active) {
            manager.performAction(command);
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
}
