package capabilities;

import file.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Refactoring {
    public void addNewSouvenir(String fileName, String name, String manufacturerRequisites, String date, int cost) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        //if (!writer) {
        writer.newLine();
         writer.write(name + "|" + manufacturerRequisites + "|" + date + "|" + cost);
       // }
       // else {
       //     System.out.println("Add manufacturer into the file!");
       // }
        writer.close();
    }
    public void addNewManufacturer(FileReader fileReader){

    }
    public void changeSouvenir(FileReader fileReader){

    }
    public void changeManufacturer(FileReader fileReader){

    }
}
