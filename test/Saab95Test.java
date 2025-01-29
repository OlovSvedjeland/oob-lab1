import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 Saab = new Saab95(2, Color.red, 125, false, 0, "Saab95",0 ,0, 0);

    @Test
    void setTurboOn() {
        Saab.setTurboOff();
        Saab.setTurboOn();
        assertTrue(Saab.getTurbo());
    }

    @Test
    void setTurboOff() {
    }


    @Test
    void speedFactor() {
    }
}