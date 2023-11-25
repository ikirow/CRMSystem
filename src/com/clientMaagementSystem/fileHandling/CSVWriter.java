package com.clientMaagementSystem.fileHandling;

import interfaces.Writer;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class CSVWriter implements Writer {
    @Override
    public void write(List<Serializable> items, String path) {
        try (   FileWriter writer = new FileWriter(path)) {
            for (Serializable item: items){
                writer.write(item.toString() + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
