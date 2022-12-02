package simulation.plants;

import simulation.environment.Radiation;
import simulation.environment.Weather;

public class Deltafa extends AbstractPlant{

    public Deltafa(String name, int food) {
        super(name, food);
    }

    @Override
    public void act(Weather weather) {
        consuption(weather.getRadiation(),-3,4,-1);

        if (isAlive()) {
            if(food<5){
                weather.addDeltaVote(4);
            } else if(food>5 && food<10){
                weather.addDeltaVote(1);
            }
        }
    }

    @Override
    public boolean isAlive() {
        if (alive && getFood() <= 0) {
            this.alive=false;
        }
        return alive;
    }
}
