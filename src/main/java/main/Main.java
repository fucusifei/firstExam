package main;

import capabilities.Refactoring;
import capabilities.View;
import file.FileReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        new Main().run();
    }
    private void run() throws IOException {
        FileReader fileReader = new FileReader();
        fileReader.read();

        View view = new View();
        Refactoring refactoring = new Refactoring();
        refactoring.addNewSouvenir(fileReader.dir +"\\"+"ChinaSouvenirsCompany.txt", "new","4325","2022-12-09",1234);
        //view.viewAllSouvenir(fileReader);
       // view.viewAllManufacturer(fileReader);
        //view.countrySouvenirInfo("USA",fileReader);
        //view.manufacturerSouvenirInfo("ChinaSouvenir",fileReader);
        //view.costOnSouvenirManufacturerInfo(1000,fileReader);
       // view.allInfo(fileReader);
        //view.manufacturerInfoBySouvenirAndCreateDate(fileReader,2001,"Abba");
        //view.costOnSouvenirManufacturerInfo(1100,fileReader);
        //view.souvenirByYear(fileReader);
    }
}