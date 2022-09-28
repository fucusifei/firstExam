package capabilities;

import file.FileReader;
import objects.Manufacturer;
import objects.Souvenir;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Refactoring {
    public void addNewSouvenir(String fileName, String name, String manufacturerRequisites, String date, int cost) throws IOException {
        FileReader fileReader = readFromOneFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        helper(writer,fileReader);
        writer.write(name + "|" + manufacturerRequisites + "|" + date + "|" + cost);
        writer.close();
    }
    public void addNewManufacturer(String fileName, String name, String requisites, String country, long countOfSouvenirTypes) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(name + "|" + requisites + "|" + country + "|" + countOfSouvenirTypes);
        writer.close();
    }
    public void changeSouvenir(String fileName, int id, String name, String manufacturerRequisites, String date, int cost) throws IOException {
        FileReader fileReader = readFromOneFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        fileReader.souvenirs.get(id).setName(name);
        fileReader.souvenirs.get(id).setManufacturerRequisites(manufacturerRequisites);
        fileReader.souvenirs.get(id).setCreateDate(LocalDate.parse(date));
        fileReader.souvenirs.get(id).setCost(cost);
        helper(writer,fileReader);
        writer.close();
    }
    public void changeManufacturer(String fileName, String name, String requisites, String country, long countOfSouvenirTypes) throws IOException {
        FileReader fileReader = readFromOneFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        fileReader.manufacturers.get(0).setName(name);
        fileReader.manufacturers.get(0).setRequisites(requisites);
        fileReader.manufacturers.get(0).setCountry(country);
        fileReader.manufacturers.get(0).setCountOfSouvenirTypes(countOfSouvenirTypes);
        helper(writer,fileReader);
        writer.close();
    }
    public void deleteAll(String fileCompanyName) {
        File file = new File(fileCompanyName);
        if (file.exists()){
            file.delete();
        }
        else {
            System.out.println("no such file exists");
        }
    }
    private void helper(BufferedWriter writer, FileReader fileReader) throws IOException{
        for (Manufacturer manufacturer: fileReader.manufacturers) {
            writer.write(manufacturer.getName() + "|" + manufacturer.getRequisites() + "|" + manufacturer.getCountry() + "|" + manufacturer.getCountOfSouvenirTypes());
            writer.newLine();
        }
        for (Souvenir souvenir: fileReader.souvenirs) {
            writer.write(souvenir.getName() + "|" + souvenir.getManufacturerRequisites() + "|" + souvenir.getCreateDate() + "|" + souvenir.getCost());
            writer.newLine();

        }
    }
    private FileReader readFromOneFile (String fileName) throws IOException {
        FileReader fileReader = new FileReader();
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8);
        fileReader.readManufacturerInfo(reader);
        fileReader.readSouvenirInfo(reader);
        return fileReader;
    }


}
