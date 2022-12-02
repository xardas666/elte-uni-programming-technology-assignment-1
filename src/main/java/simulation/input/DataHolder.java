package simulation.input;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private int numberOfPlants;
    private int numberOfDays;
    private List<InitialPlantData> initialPlantArray;

    public int getNumberOfPlants() {
        return numberOfPlants;
    }

    public void setNumberOfPlants(int numberOfPlants) {
        this.numberOfPlants = numberOfPlants;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }



    public List<InitialPlantData> getInitialPlantArray() {
        if (initialPlantArray == null) {
            this.initialPlantArray = new ArrayList<>();
        }
        return initialPlantArray;
    }

    public void setInitialPlantArray(List<InitialPlantData> initialPlantArray) {
        this.initialPlantArray = initialPlantArray;
    }

    static public class InitialPlantData {
        String name;
        String type;
        String food;

        public InitialPlantData(String input) {
            name = input.split(" ")[0];
            type = input.split(" ")[1];
            food = input.split(" ")[2];
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }
    }

}
