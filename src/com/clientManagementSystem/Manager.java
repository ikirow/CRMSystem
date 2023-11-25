package com.clientManagementSystem;

import com.services.ClientsService;

import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    private final ClientsService clientsService;

    public Manager(ClientsService clientClientsService) {
        this.clientsService = clientClientsService;
    }

    public void performAction(String command) {
        if (command.startsWith("Add Client")) {
            System.out.println("To add client please provide client info in the following format [id], [name], [industry], [contact person], [revenue]");
            String newClient = scanner.nextLine();
            Client client = parseClientDetails(newClient);
            clientsService.addClient(client);
        } else if (command.startsWith("Update Client")) {
            System.out.println("Enter client ID to update: ");
            int clientId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter updated client details [Name], [Industry], [ContactPerson], [Revenue]: ");
            String updatedDetails = scanner.nextLine();
            Client updatedClient = parseUpdatedClientDetails(clientId, updatedDetails);

            if (updatedClient != null) {
                clientsService.updateClient(clientId, updatedClient);
                System.out.println("Client updated successfully.");
            } else {
                System.out.println("Failed to update client. Please check your input.");
            }
        } else if (command.startsWith("Search by Industry")) {
            System.out.println("Enter Industry to search by: ");
            String industry = scanner.nextLine();
            clientsService.searchByIndustry(industry);
        } else if (command.startsWith("View Clients")) {
            clientsService.viewClients();
        } else if (command.startsWith("Search by ID")) {
            System.out.println("Enter ID to search by: ");
            int id = scanner.nextInt();
            clientsService.searchById(id);
        } else if (command.startsWith("Remove Client")) {
            System.out.println("Enter ID of the client to be removed: ");
            int id = scanner.nextInt();
            clientsService.removeClient(id);
        } else if (command.startsWith("Search by Name")) {
            System.out.println("Enter Name to search by: ");
            String name = scanner.nextLine();
            clientsService.searchByName(name);
        } else if (command.startsWith("Save and Exit")) {
            clientsService.saveData();
        } else {
            System.out.println("Unknown command");
        }

    }

    private Client parseClientDetails(String command) {
        String[] parts = command.split(", ");
        if (parts.length != 5) {
            System.out.println("Invalid input format. Please provide client info in the following format: [id], [name], [industry], [contact person], [revenue]");
            return null;
        }
        try {
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String industry = parts[2];
            String contactPerson = parts[3];
            double revenue = Double.parseDouble(parts[4]);

            return new Client(id, name, industry, contactPerson, revenue);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric values. Please provide valid numeric input for ID and revenue.");
            return null;
        }
    }

    private Client parseUpdatedClientDetails(int clientId, String updatedDetails) {
        String[] parts = updatedDetails.split(", ");
        if (parts.length != 4) {
            System.out.println("Invalid input format. Please provide client info in the following format:  [name], [industry], [contact person], [revenue]");
            return null; // Invalid input, return null
        }
        try {
            String name = parts[0];
            String industry = parts[1];
            String contactPerson = parts[2];
            double revenue = Double.parseDouble(parts[3]);

            return new Client(clientId, name, industry, contactPerson, revenue);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric values. Please provide valid numeric input for ID and revenue.");
            return null;
        }
    }

}
