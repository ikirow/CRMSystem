package com.clientMaagementSystem.fileHandling;

import com.clientManagementSystem.Client;
import interfaces.Writer;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class CSVWriter implements Writer {
    @Override
    public void write(List<Client> clients, String path) {
        try (   FileWriter writer = new FileWriter(path)) {
            for (Serializable client: clients){
                writer.write(client.toString() + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
