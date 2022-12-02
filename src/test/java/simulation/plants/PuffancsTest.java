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
public class PuffancsTest {

    Puffancs plant;
    Weather weather;

    @Before
    public void setUp() {
        plant = new Puffancs("test", 3);
        weather = new Weather();
    }

    @Test
    public void actOnAlpha() {
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        assertTrue(plant.getFood()==5);
        assertTrue(weather.getDeltaVote()==0);
        assertTrue(weather.getAlphaVote()==10);
    }

    @Test
    public void actOnDelta() {
        weather.setRadiation(Radiation.DELTA);
        plant.act(weather);
        assertTrue(plant.getFood()==1);
        assertTrue(weather.getDeltaVote()==0);
        assertTrue(weather.getAlphaVote()==10);
    }

    @Test
    public void actOnNonRadioactiveDay() {
        weather.setRadiation(Radiation.NONE);
        plant.act(weather);
        assertTrue(plant.getFood()==2);
        assertTrue(weather.getDeltaVote()==0);
        assertTrue(weather.getAlphaVote()==10);
    }

    @Test
    public void isAliveBelowZero() {
        assertTrue(plant.isAlive());
        weather.setRadiation(Radiation.NONE);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        assertFalse(plant.isAlive());
    }

    @Test
    public void isAliveAboweTen() {
        assertTrue(plant.isAlive());
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        plant.act(weather);
        assertFalse(plant.isAlive());
    }
}