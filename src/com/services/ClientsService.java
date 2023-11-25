package com.services;

import com.clientMaagementSystem.fileHandling.CSVReader;
import com.clientMaagementSystem.fileHandling.CSVWriter;
import com.clientManagementSystem.Client;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ClientsService {
    private final CSVReader fileReader;
    private final CSVWriter fileWriter;
    private List<Client> clients;

    public ClientsService(CSVReader fileReader, CSVWriter fileWriter, List<Client> clients) {
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

        if (client != null) {
            if (!isClientIdUnique(client.getID())) {
                System.out.println("Error: Client with ID " + client.getID() + " already exists. Please choose a unique ID.");
                return;
            }
            clients.add(client);
            System.out.println("Client added successfully.");
        } else {
            System.out.println("Failed to add client. Client information is null.");
        }

    }

    private boolean isClientIdUnique(int clientId) {
        for (Client existingClient : clients) {
            if (existingClient.getID() == clientId) {
                return false;
            }
        }
        return true;
    }
    public List<Client> updateClient(int clientId, Client updatedClient) {

        if(updatedClient != null){
            for (Client client : clients) {
                if (client.getID() == clientId) {
                    client.setName(updatedClient.getName());
                    client.setIndustry(updatedClient.getIndustry());
                    client.setContactPerson(updatedClient.getContactPerson());
                    client.setRevenue(updatedClient.getRevenue());
                    break;
                }
            }
        }
        return clients;
    }

    public List<Client> viewClients() {
        for (Client client : clients)
        {
            System.out.println(client);
        }
        return clients;
    }

    public List<Client> searchById(int id) {
        for (Client client : clients)
        {
            if (id == client.getID()){
                System.out.println(client);
            } else {
                System.out.println("There is no client with such ID");
            }
        }
        return clients;
    }

    public List<Client> searchByName(String name) {
        for (Client client : clients)
        {
            if (Objects.equals(name, client.getName())){
                System.out.println(client);
            } else {
                System.out.println("There is no client with such Name");
            }
        }
        return clients;
    }

    public List<Client> searchByIndustry(String industry) {
        for (Client client : clients)
        {
            if (Objects.equals(industry, client.getIndustry())){
                System.out.println(client);
            } else {
                System.out.println("There are no clients with such Industry");
            }
        }
        return clients;
    }

    public List<Client> removeClient(int clientId){
        clients.removeIf(client -> client.getID() == clientId);
        System.out.println("cliens after removal");
        for (Client client : clients)
        {
                System.out.println(client);
        }
        return clients;
    }
    public void saveData() {
        System.out.println("cliens before save");
        for (Client client : clients)
        {
            System.out.println(client);
        }
        fileWriter.write(clients, "src/clientsList.csv");
    }
}
