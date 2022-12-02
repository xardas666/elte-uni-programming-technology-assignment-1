package simulation.plants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import simulation.environment.Radiation;
import simulation.environment.Weather;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class DeltafaTest {

    Deltafa plant;
    Weather weather;

    @Before
    public void setUp() {
        plant = new Deltafa("", 10);
        weather = new Weather();
    }

    @Test
    public void actOnAlpha() {
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        assertTrue(plant.getFood()==7);
    }

    @Test
    public void actOnDelta() {
        weather.setRadiation(Radiation.DELTA);
        plant.act(weather);
        assertTrue(plant.getFood()==14);
    }

    @Test
    public void actOnNonRadioactiveDay() {
        weather.setRadiation(Radiation.NONE);
        plant.act(weather);
        assertTrue(plant.getFood()==9);
    }

    @Test
    public void actOnWeather() {
        //ha 10-nél több, akkor nem befolyásolja a másnapi sugárzást
        weather.setRadiation(Radiation.DELTA);
        plant.act(weather);
        assertTrue(plant.getFood()==14);
        assertTrue(weather.getDeltaVote()==0);
        assertTrue(weather.getAlphaVote()==0);

        //ha 5 és 10 közé esik, akkor 1 értékben növeli a delta sugárzás bekövetkezését,
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        plant.act(weather);
        assertTrue(plant.getFood()==8);
        assertTrue(weather.getDeltaVote()==1);
        assertTrue(weather.getAlphaVote()==0);

        //Ha a tápanyag mennyisége 5-nél kisebb, akkor 4 értékben növeli a delta sugárzás bekövetkezését,
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        plant.act(weather);
        assertTrue(plant.getFood()==2);
        assertTrue(weather.getDeltaVote()==5); //1+4 mert 2 időjárás hívás volt
        assertTrue(weather.getAlphaVote()==0);
    }

    @Test
    public void isAlive() {
        assertTrue(plant.isAlive());
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        assertFalse(plant.isAlive());
    }
}