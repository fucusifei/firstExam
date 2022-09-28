package main;

import capabilities.Refactoring;
import capabilities.View;
import file.FileReader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        new Main().run();
    }
    private void run() throws IOException {
        FileReader fileReader = new FileReader();
        fileReader.read();
        View view = new View();
        Refactoring refactoring = new Refactoring();
        int input = 0;
        while (input != 13) {
            System.out.println("Выберите любую функцию из списка");
            System.out.println("1) Добавить производителя");
            System.out.println("2) Добавить сувенир");
            System.out.println("3) Редактировать производителя");
            System.out.println("4) Редактировать сувенир");
            System.out.println("5) Просмотреть всех производителей и их сувениры");
            System.out.println("6) Вывести информацию о сувенирах заданного производителя");
            System.out.println("7) Вывести информацию о сувенирах, произведенных в заданной стране");
            System.out.println("8) Вывести информацию о производителях, чьи цены на сувениры\n" +
                    "меньше заданной");
            System.out.println("9) Вывести информацию по всем производителям и, для каждого производителя вывести\n" +
                    "информацию о всех сувенирах, которые он производит");
            System.out.println("10) Вывести информацию о производителях заданного сувенира, произведенного в заданном\n" +
                    "году");
            System.out.println("11) Для каждого года вывести список сувениров, произведенных в этом году.");
            System.out.println("12) Удалить заданного производителя и его сувениры.");
            System.out.println("13) Завершить работу");
            System.out.println("Select any function from the list");

            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            switch (input) {
                case 1 -> {
                    Scanner in2 = new Scanner(System.in);
                    String searchWord = in2.nextLine();
                    String searchWord2 = in2.nextLine();
                    String searchWord3 = in2.nextLine();
                    String searchWord4 = in2.nextLine();
                    String searchWord5 = in2.nextLine();
                    refactoring.addNewManufacturer(searchWord,searchWord2,searchWord3,searchWord4,Long.parseLong(searchWord5));
                }
                default -> input = 6;
            }
        }


        //refactoring.deleteAll(fileReader.dir + "\\" + "AsianSouvenirsCompany.txt");
        //refactoring.addNewManufacturer(fileReader.dir + "\\" + "AsianSouvenirsCompany.txt","Asia Souvenirs","55673","Japan",3);
       //refactoring.addNewSouvenir(fileReader.dir + "\\" + "AsianSouvenirsCompany.txt", "new","4325","2022-12-09",1234);
       // refactoring.changeSouvenir(fileReader.dir +"\\"+"AsianSouvenirsCompany.txt", 0,"NEW","5567","2011-10-09",2000);
        //refactoring.changeManufacturer(fileReader.dir +"\\"+ "AsianSouvenirsCompany.txt","Japan Souvenirs","10000","Japan",2);
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