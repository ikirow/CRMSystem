package com.clientMaagementSystem.fileHandling;

import com.clientManagementSystem.Client;
import interfaces.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader implements Reader {
    @Override
    public List<Client> read(List<Client> items, String path) {
        List<Client> clients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                clients.add(new Client(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        Double.parseDouble(values[4])
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }
}


