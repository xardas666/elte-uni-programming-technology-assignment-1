package simulation.plants;

import simulation.environment.Radiation;
import simulation.environment.Weather;

public abstract class AbstractPlant {
    protected String name;
    protected int food;
    protected boolean alive;

    public AbstractPlant(String name, int food) {
        this.name = name;
        this.food = food;
        this.alive = true;
    }

    public abstract void act(Weather weather);

    public abstract boolean isAlive();

    protected void consuption(Radiation actualRadiation, int alphaModifier, int deltaModifier, int nonRadioactiveModifier) {
        if (Radiation.ALPHA.equals(actualRadiation)) {
            addOrSubstractFood(alphaModifier);
        } else if (Radiation.DELTA.equals(actualRadiation)) {
            addOrSubstractFood(deltaModifier);
        } else {
            addOrSubstractFood(nonRadioactiveModifier);
        }
    }

    public String getName() {
        return name;
    }

    public int getFood() {
        return food;
    }

    protected void addOrSubstractFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return "AbstractPlant{" +
                "name='" + name + '\'' +
                ", food=" + food +
                ", alive=" + alive +
                '}';
    }
}
