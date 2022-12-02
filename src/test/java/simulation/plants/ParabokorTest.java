package simulation.plants;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import simulation.environment.Radiation;
import simulation.environment.Weather;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParabokorTest {

    Parabokor plant;
    Weather weather;

    @Before
    public void setUp() {
        plant = new Parabokor("test", 1);
        weather = new Weather();
    }

    //Parabokor: Akár alfa, akár delta sugárzás hatására a tápanyag mennyisége eggyel nő.
    //Sugárzásnélküli napon a tápanyag eggyel csökken. A másnapi sugárzást nem befolyásolja.

    //Először a tápanyag változik, és ha a növény ezután él, akkor befolyásolhatja a sugárzást.

    @Test
    public void actOnAlpha() {
        weather.setRadiation(Radiation.ALPHA);
        plant.act(weather);
        assertTrue(plant.getFood()==2);
    }

    @Test
    public void actOnDelta() {
        weather.setRadiation(Radiation.DELTA);
        plant.act(weather);
        assertTrue(plant.getFood()==2);
    }

    @Test
    public void actOnNonRadioactiveDay() {
        weather.setRadiation(Radiation.NONE);
        plant.act(weather);
        assertTrue(plant.getFood()==0);
    }

    @Test
    public void isAlive() {
        assertTrue(plant.isAlive());
        weather.setRadiation(Radiation.NONE);
        plant.act(weather);
        assertFalse(plant.isAlive());
    }
}