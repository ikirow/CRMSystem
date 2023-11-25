package com.clientManagementSystem;

import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    private final Service service;

    public Manager(Service clientService) {
        this.service = clientService;
    }

    public void performAction(String command) {
        if (command.startsWith("Add Client")) {
            System.out.println("To add client please provide client info in the following format [id], [name], [industry], [contact person], [revenue]");
            String newClient = scanner.nextLine();
            Client client = parseClientDetails(newClient);
            service.addClient(client);
        } else if (command.startsWith("Update Client")) {
            System.out.println("Enter client ID to update: ");
            int clientId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter updated client details (Name, Industry, ContactPerson, Revenue): ");
            String updatedDetails = scanner.nextLine();

            Client updatedClient = parseClientDetails(updatedDetails);

            service.updateClient(clientId, updatedClient);
        } else if (command.startsWith("Save & Exit")) {

            service.saveData();
        }

    }

    private Client parseClientDetails(String command) {
        String[] parts = command.split(", ");

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String industry = parts[2];
        String contactPerson = parts[3];
        double revenue = Double.parseDouble(parts[4]);

        return new Client(id, name, industry, contactPerson, revenue);
    }

}
