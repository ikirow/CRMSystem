package com.clientManagementSystem;

public class Manager {
    private final Service service;

    public Manager(Service clientService) {
        this.service = clientService;
    }

    public void performAction(String command) {
        // Based on the command, delegate to the appropriate method in ClientService
        if (command.startsWith("Add Client")) {
            // Parse the command and extract client details
            Client client = parseClientDetails(command);
            service.addClient(client);
        } else if (command.startsWith("Update Client")) {
            // Similar logic for other commands
        } else if (command.startsWith("Save & Exit")) {
            // Similar logic for other commands
            service.saveData();
        }
        // Other conditionals for different commands
    }

    private Client parseClientDetails(String command) {
        String[] parts = command.split(", ");
        //We start from 1 since 0 is the command
        int id = Integer.parseInt(parts[1]);
        String name = parts[2];
        String industry = parts[3];
        String contactPerson = parts[4];
        double revenue = Double.parseDouble(parts[5]);

        return new Client(id, name, industry, contactPerson, revenue);
    }

}
