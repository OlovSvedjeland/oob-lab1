import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 Saab = new Saab95(2, Color.red, 125, false, 0, "Saab95");

    @Test
    void setTurboOn() { // Kollar så settermetoden för Saab fungerar
        Saab.setTurboOff();
        Saab.setTurboOn();
        assertTrue(Saab.getTurbo());
    }

    @Test
    void setTurboOff() { // Kollar så settermetoden för Saab fungerar
        Saab.setTurboOn();
        Saab.setTurboOff();
        assertFalse(Saab.getTurbo());
    }

    @Test
    void speedFactorTurboOn() { // Kollar så hastigheten ändras rätt vid turbo
        Saab.setTurboOn();
        double expectedSpeedFactor = Saab.getEnginePower() * 0.01 * 1.3;
        assertEquals(expectedSpeedFactor,Saab.speedFactor(), 0.0001); //Delta är toleransnivå för avrundsfel
    }

    @Test
    void speedFactorTurboOff(){ // Kollar så hastigheten ändras rätt vid avstängd turbo
        Saab.setTurboOff();
        double expectedSpeedFactor = Saab.getEnginePower() * 0.01 * 1.0;
        assertEquals(expectedSpeedFactor,Saab.speedFactor(), 0.0001);

    }
}