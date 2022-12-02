package simulation.plants;

import simulation.environment.Weather;

public class Puffancs extends AbstractPlant {

    public Puffancs(String name, int food) {
        super(name, food);
    }

    @Override
    public void act(Weather weather) {
        consuption(weather.getRadiation(), 2, -2, -1);
        if (isAlive()) {
            weather.addAlphaVote(10);
        }
    }

    @Override
    public boolean isAlive() {
        if (alive && (getFood() > 10 || getFood() <= 0)) {
            this.alive = false;
        }
        return alive;
    }


}