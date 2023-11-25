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

//public class CSVReader implements Reader {
//    @Override
//    public List<Client> read(List<Serializable> items, String path) {
//        List<Client> clients = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//            String line;
//            String firstLine = br.readLine();
//            String[] headerFields = firstLine.split(",");
//
//            boolean hasHeaders = Arrays.stream(headerFields)
//                    .allMatch(field -> Character.isUpperCase(field.charAt(0)));
//            while ((line = br.readLine()) != null){
//
//                String[] values = line.split(",");
//                if (values.length == 5) { // hardcoded = bad
//                    try {
//                        int id = Integer.parseInt(values[0]);
//                        String name = values[1];
//                        String industry = values[2];
//                        String contactPerson = values[3];
//                        double revenue = Double.parseDouble(values[4]);
//
//                        // TODO: validation of input data
//                        clients.add(new Client(id, name, industry, contactPerson, revenue));
//                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
//                        System.err.println("Error validating input data: " + line);
//                        e.printStackTrace();
//                    }
//                } else {
//                    // Handle cases where the number of columns is unexpected
//                    System.err.println("Unexpected number of columns: " + line);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return clients;
//    }
//}
