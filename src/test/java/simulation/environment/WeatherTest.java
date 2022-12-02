package simulation.environment;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherTest {

    Weather weather;

    @Before
    public void setUp() {
        weather = new Weather();
    }

    //Az első nap sugárzás nélküli.
    @Test
    public void firstDayNonRadioactiveDay() {
        assertEquals(weather.getRadiation(), Radiation.NONE);
    }

    //ha az alfa sugárzásra beérkezett igények összege legalább hárommal meghaladja a delta sugárzás igényeinek összegét, akkor alfa sugárzás lesz;
    @Test
    public void calculateAlpha() {
        weather.addAlphaVote(3);
        weather.addDeltaVote(0);
        weather.calculate();
        assertEquals(weather.getRadiation(), Radiation.ALPHA);
    }

    //ha a delta sugárzásra igaz ugyanez, akkor delta sugárzás lesz;
    @Test
    public void calculateDelta() {
        weather.addAlphaVote(0);
        weather.addDeltaVote(3);
        weather.calculate();
        assertEquals(weather.getRadiation(), Radiation.DELTA);
    }

    //ha a két igény közti eltérés háromnál kisebb, akkor nincs sugárzás.
    @Test
    public void calculateNonRadioactiveDay() {
        weather.addAlphaVote(2);
        weather.addDeltaVote(3);
        weather.calculate();
        assertEquals(weather.getRadiation(), Radiation.NONE);
    }

}