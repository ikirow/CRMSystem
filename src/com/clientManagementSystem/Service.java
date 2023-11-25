package com.clientManagementSystem;

import com.clientMaagementSystem.fileHandling.CSVReader;
import com.clientMaagementSystem.fileHandling.CSVWriter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Service {
    private final CSVReader fileReader;
    private final CSVWriter fileWriter;
    private final List<Serializable> clients;

    public Service(CSVReader fileReader, CSVWriter fileWriter, List<Serializable> clients) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.clients = clients;
        initializeData();
    }

    private void initializeData() {
        clients.addAll(fileReader.read(Collections.singletonList(Client.class), "src/clientsList.csv"));
        System.out.println(clients);
    }

    public void addClient(Client client) {
        clients.add(client);
        fileWriter.write(clients, "src/clientsList.csv");
//        saveData();
    }

    public List<Serializable> viewClients() {
        return clients;
    }

    public void saveData() {
        fileWriter.write(clients, "src/clientsList.csv");
    }
}
