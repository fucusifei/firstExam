package file;

import objects.Manufacturer;
import objects.Souvenir;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<Manufacturer> manufacturers = new ArrayList<>();
    public List<Souvenir> souvenirs= new ArrayList<>();
    public String dir = "Manufacturer";
    public void read() throws IOException {
        BufferedReader reader;
        for (File pathName : pathName()) {
            reader = Files.newBufferedReader(Paths.get(pathName.toString()), StandardCharsets.UTF_8);
            readManufacturerInfo(reader);
            readSouvenirInfo(reader);
            reader.close();
        }
    }
    public List<File> pathName() throws IOException{
        try(Stream<Path> pathStream =  Files.walk(Paths.get(dir))){
            return pathStream.filter(Files::isRegularFile).map(Path::toFile).toList();
        }
    }
    public void readManufacturerInfo(BufferedReader reader) {
        List<String> manufacturersInfo = reader.lines().limit(1).flatMap(x -> Arrays.stream(x.split("\\|"))).filter(x -> !x.isEmpty()).toList();
        if (!manufacturersInfo.isEmpty()) {
            manufacturers.add(new Manufacturer(manufacturersInfo.get(0), manufacturersInfo.get(1), manufacturersInfo.get(2), Long.parseLong(manufacturersInfo.get(3))));
        }
    }
    public void readSouvenirInfo(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        List<String> souvenirsInfo;
        while (line != null){
            souvenirsInfo = line.lines().flatMap(x -> Arrays.stream(x.split("\\|"))).filter(x -> !x.isEmpty()).toList();
            if (!souvenirsInfo.isEmpty()) {
                souvenirs.add(new Souvenir(souvenirsInfo.get(0), souvenirsInfo.get(1), LocalDate.parse(souvenirsInfo.get(2)), Integer.parseInt(souvenirsInfo.get(3))));
            }
            line = reader.readLine();
        }
    }

}
