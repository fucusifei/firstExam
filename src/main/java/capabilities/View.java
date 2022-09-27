package capabilities;

import file.FileReader;
import objects.Manufacturer;
import objects.Souvenir;

import java.util.*;
import java.util.stream.Collectors;

public class View {
    public void manufacturerSouvenirInfo(String manufacturerName, FileReader fileReader) {//+
        List<Manufacturer> list = fileReader.manufacturers.stream().filter(x -> x.getName().equals(manufacturerName)).toList();
        fileReader.souvenirs.stream().filter(x -> x.getManufacturerRequisites().equals(list.get(0).getRequisites())).forEach(System.out::println);
    }

    public void countrySouvenirInfo(String souvenirCountry, FileReader fileReader) {//+
        List<Manufacturer> list = fileReader.manufacturers.stream()
                .filter(x -> x.getCountry().equals(souvenirCountry))
                .toList();
        fileReader.souvenirs.stream()
                .filter(x -> x.getManufacturerRequisites().equals(list.get(0).getRequisites()))
                .forEach(System.out::println);
    }

    public void costOnSouvenirManufacturerInfo(int souvenirCost, FileReader fileReader) {//+
        Map<String,Long> map = fileReader.souvenirs.stream()
                .filter(x -> x.getCost() < souvenirCost)
                .map(Souvenir::getManufacturerRequisites)
                .collect(Collectors.toMap(x -> x,x -> 1L, Long::sum));
        fileReader.manufacturers.stream()
                .filter(x -> x.getCountOfSouvenirTypes() == map.get(x.getRequisites()))
                .forEach(System.out::println);
    }

    public void allInfo(FileReader fileReader) {//+
        for (Iterator<Manufacturer> iterator = fileReader.manufacturers.iterator(); iterator.hasNext(); ) {
            Manufacturer next = iterator.next();
            System.out.println(next);
            fileReader.souvenirs.stream().filter(x->x.getManufacturerRequisites().equals(next.getRequisites())).forEach(System.out::println);

        }
    }
    public void manufacturerInfoBySouvenirAndCreateDate(FileReader fileReader, int date, String souvenirName) {//+
        List<Souvenir> list = fileReader.souvenirs.stream()
                .filter(x -> x.getName().equals(souvenirName))
                .filter(y -> y.getCreateDate().getYear()==date)
                .toList();
        for (Souvenir souvenir : list) {
            fileReader.manufacturers.stream()
                    .filter(x -> x.getRequisites().equals(souvenir.getManufacturerRequisites()))
                    .forEach(System.out::println);
        }
    }
    public void souvenirByYear(FileReader fileReader) {//+
        List<Integer> dateList = fileReader.souvenirs.stream()
                .map(x -> x.getCreateDate().getYear())
                .distinct()
                .sorted()
                .toList();
        for (Integer date : dateList) {
            System.out.println("Souvenirs were made in " + date);
            fileReader.souvenirs.stream().filter(x -> x.getCreateDate().getYear() == date).forEach(System.out::println);
        }
    }
    public void viewAllSouvenir(FileReader fileReader) {
        fileReader.souvenirs.forEach(System.out::println);
    }
    public void viewAllManufacturer(FileReader fileReader) {
        fileReader.manufacturers.forEach(System.out::println);
    }
}

