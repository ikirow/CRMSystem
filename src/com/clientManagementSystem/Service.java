package com.clientManagementSystem;

import com.clientMaagementSystem.fileHandling.CSVReader;
import com.clientMaagementSystem.fileHandling.CSVWriter;

import java.io.Serializable;
import java.util.List;

public class Service {
    private final CSVReader fileReader;
    private final CSVWriter fileWriter;
    private final List<Client> clients;

    public Service(CSVReader fileReader, CSVWriter fileWriter, List<Client> clients) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.clients = clients;
        initializeData();
    }

    private void initializeData() {
        clients.addAll(fileReader.read(clients, "src/clientsList.csv"));
        System.out.println(clients);
    }

    public void addClient(Client client) {
        clients.add(client);
        fileWriter.write(clients, "src/clientsList.csv");
//        saveData();
    }

    public void updateClient(int clientId, Client updatedClient) {
        // Find the client with the specified ID and update its values
        for (Client client : clients) {
            if (client.getID() == clientId) {
                client.setName(updatedClient.getName());
                client.setIndustry(updatedClient.getIndustry());
                client.setContactPerson(updatedClient.getContactPerson());
                client.setRevenue(updatedClient.getRevenue());
                break; // Stop searching once the client is found and updated
            }
        }

        fileWriter.write(clients, "src/clientsList.csv");
    }

    public List<Client> viewClients() {
        return clients;
    }

    public void saveData() {
        fileWriter.write(clients, "src/clientsList.csv");
    }
}
