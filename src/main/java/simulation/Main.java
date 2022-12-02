package simulation;

import simulation.environment.Weather;
import simulation.input.ConfigFileLoader;
import simulation.input.DataHolder;
import simulation.plants.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static ConfigFileLoader configFileLoader;

    public static void main(String[] args) {
        try {
            configFileLoader = new ConfigFileLoader();

            DataHolder dataHolder = configFileLoader.loadData(args[0]);

            ArrayList<AbstractPlant> plants = transformToPlantObject(dataHolder.getInitialPlantArray());

            Weather weather = new Weather();

            for (int i = 0; i < dataHolder.getNumberOfDays(); i++) {
                System.out.println("------------- SOD " + i + "------------- ");
                System.out.println(weather);
                plants.forEach(x -> x.act(weather));
                plants.forEach(System.out::println);
                System.out.println(weather);
                weather.calculate();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<AbstractPlant> transformToPlantObject(List<DataHolder.InitialPlantData> initialPlantArray) {
        ArrayList<AbstractPlant> plants = new ArrayList<>();

        for (DataHolder.InitialPlantData initialPlantData : initialPlantArray) {
            AbstractPlant plant;

            if (initialPlantData.getType().equals(PlantIdentifier.DELTAFA.getIdentifier())) {
            plant = new Deltafa(initialPlantData.getName(),Integer.parseInt(initialPlantData.getFood()));
            } else if (initialPlantData.getType().equals(PlantIdentifier.PARABOKOR.getIdentifier())) {
                plant = new Parabokor(initialPlantData.getName(),Integer.parseInt(initialPlantData.getFood()));
            } else if (initialPlantData.getType().equals(PlantIdentifier.PUFFANCS.getIdentifier())) {
                plant = new Puffancs(initialPlantData.getName(),Integer.parseInt(initialPlantData.getFood()));
            } else {
                throw new IllegalArgumentException("nem létező növény!");
            }

            plants.add(plant);
        }

        return plants;
    }


}
