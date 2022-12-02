package simulation.input;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFileLoader {

    public DataHolder loadData(String fileName) {
        Path inputFilePath = Paths.get(fileName);

        if (isExists(inputFilePath)) {
            DataHolder dataHolder = new DataHolder();

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath.toString()), StandardCharsets.UTF_8));

                LineNumberReader lineReader = new LineNumberReader(reader);
                String line = null;

                dataHolder.setNumberOfPlants(Integer.parseInt(lineReader.readLine()));
                int actualCount = 0;
                while (dataHolder.getNumberOfPlants()>actualCount) {
                    dataHolder.getInitialPlantArray().add(new DataHolder.InitialPlantData(lineReader.readLine()));
                    actualCount++;
                }

                dataHolder.setNumberOfDays(Integer.parseInt(lineReader.readLine()));

                return dataHolder;

            } catch (IOException ex) {
                throw new IllegalArgumentException("Hiba a file feldolgozása során");
            }
        }

        throw new IllegalArgumentException("File nem létezik vagy hiányzik");
    }

    private static boolean isExists(Path path) {
        return Files.exists(path) && !Files.isDirectory(path);
    }
}
