package main;

import capabilities.Refactoring;
import capabilities.View;
import file.FileReader;

import java.io.IOException;
import java.time.LocalDate;
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
            System.out.println("5) Просмотреть всех производителей и все сувениры");
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
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название файла для записи");
                    String fileName = scanner.nextLine();
                    System.out.println("Введите название производителя");
                    String name = scanner.nextLine();
                    System.out.println("Введите реквизиты производителя");
                    String requisites = scanner.nextLine();
                    System.out.println("Введите страну производителя");
                    String country = scanner.nextLine();
                    System.out.println("Введите количество сувениров производителя");
                    long countOfSouvenirTypes = scanner.nextLong();

                    refactoring.addNewManufacturer(fileReader.dir + "\\" + fileName,name,requisites,country,countOfSouvenirTypes);
                    System.out.println("Файл с производителем успешно создан!");
                }
                case 2 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название файла для записи");
                    String fileName = scanner.nextLine();
                    System.out.println("Введите название сувенира");
                    String name = scanner.nextLine();
                    System.out.println("Введите реквизиты производителя");
                    String requisites = scanner.nextLine();
                    System.out.println("Введите дату создания в виде хххх-хх-хх");
                    String date = scanner.nextLine();
                    System.out.println("Введите цену на сувенир");
                    int cost = scanner.nextInt();

                    refactoring.addNewSouvenir(fileReader.dir + "\\" + fileName,name,requisites, date,cost);
                    System.out.println("Сувенир успешно создан!");
                }
                case 3 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название файла для редактирования производителя");
                    String fileName = scanner.nextLine();
                    System.out.println("Введите новое название производителя");
                    String name = scanner.nextLine();
                    System.out.println("Введите новые реквизиты производителя");
                    String requisites = scanner.nextLine();
                    System.out.println("Введите новую страну производителя");
                    String country = scanner.nextLine();
                    System.out.println("Введите новое количество сувениров производителя");
                    long countOfSouvenirTypes = scanner.nextLong();

                    refactoring.changeManufacturer(fileReader.dir + "\\" + fileName,name,requisites,country,countOfSouvenirTypes);
                    System.out.println("Производитель успешно изменен!");
                }
                case 4 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название файла с нужным сувениром");
                    String fileName = scanner.nextLine();
                    refactoring.readFromOneFile(fileReader.dir + "\\" +fileName).souvenirs.forEach(System.out::println);
                    System.out.println("Введите номер сувенира из списка");
                    int souvenirId = scanner.nextInt();
                    System.out.println("Введите новое название сувенира");
                    String name = scanner.nextLine();
                    System.out.println("Введите новые реквизиты производителя");
                    String requisites = scanner.nextLine();
                    System.out.println("Введите новую дату создания в виде хххх-хх-хх");
                    String date = scanner.nextLine();
                    System.out.println("Введите новую цену на сувенир");
                    int cost = scanner.nextInt();

                    refactoring.changeSouvenir(fileReader.dir + "\\" + fileName,souvenirId,name,requisites, date,cost);
                    System.out.println("Сувенир успешно изменен!");
                }
                case 5 -> {
                    System.out.println("Информация про всех производителей и сувениры");
                    view.viewAllManufacturer(fileReader);
                    view.viewAllSouvenir(fileReader);
                }
                case 6 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название производителя");
                    String manufacturerName = scanner.nextLine();
                    System.out.println("Информацию о сувенирах заданного производителя");
                    view.manufacturerSouvenirInfo(manufacturerName,fileReader);
                }
                case 7 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название нужной страны");
                    String country = scanner.nextLine();
                    System.out.println("Информация о сувенирах, произведенных в заданной стране");
                    view.countrySouvenirInfo(country,fileReader);
                }
                case 8 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите нужную цену");
                    int cost = scanner.nextInt();
                    System.out.println("Информация о производителях, чьи цены на сувениры\n" +
                            "меньше заданной");
                    view.costOnSouvenirManufacturerInfo(cost,fileReader);
                }
                case 9 -> {
                    System.out.println("Информация про всех производителей и их сувениры");
                    view.allInfo(fileReader);
                }
                case 10 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите нужный год");
                    int year = scanner.nextInt();
                    System.out.println("Введите название сувенира");
                    String souvenirName = scanner.nextLine();
                    System.out.println("Информация о производителях заданного сувенира, произведенного в заданном\n" +
                            "году");
                    view.manufacturerInfoBySouvenirAndCreateDate(fileReader,year,souvenirName);
                }
                case 11 -> {
                    System.out.println("Список сувениров, произведенных в каждом году.");
                    view.souvenirByYear(fileReader);
                }
                case 12 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введитет название файла для удаления");
                    String fileName = scanner.nextLine();
                    refactoring.deleteAll(fileReader.dir + "\\" + fileName);
                    System.out.println("Файл успешно удален!");
                }
                default -> input = 13;
            }
        }
    }
}