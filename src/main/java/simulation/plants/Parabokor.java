package simulation.plants;

import simulation.environment.Weather;

public class Parabokor extends AbstractPlant{

    public Parabokor(String name, int food) {
        super(name, food);
    }

    @Override
    public void act(Weather weather) {
        consuption(weather.getRadiation(),1,1,-1);
        isAlive();
    }

    @Override
    public boolean isAlive() {
        if (alive && getFood() <= 0) {
            this.alive=false;
        }
        return alive;
    }


}