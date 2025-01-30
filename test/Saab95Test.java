import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 Saab = new Saab95(2, Color.red, 125, false, 0, "Saab95");

    @Test
    void setTurboOn() {
        Saab.setTurboOff();
        Saab.setTurboOn();
        assertTrue(Saab.getTurbo());
    }

    @Test
    void setTurboOff() {
        Saab.setTurboOn();
        Saab.setTurboOff();
        assertFalse(Saab.getTurbo());
    }


    @Test
    void speedFactorTurboOn() {
        Saab.setTurboOn();
        double expectedSpeedFactor = 100 * 0.01 * 1.3;
        assertEquals(expectedSpeedFactor,Saab.speedFactor(), 0.0001); //Delta är toleransnivå för avrundsfel
    }

    @Test
    void speedFactorTurboOff(){
        Saab.setTurboOff();
        double expectedSpeedFactor = 100 * 0.01 * 1.0;
        assertEquals(expectedSpeedFactor,Saab.speedFactor(), 0.0001);

    }
}