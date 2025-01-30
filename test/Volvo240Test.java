import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 Volvo240 = new Volvo240(4, 100, 0, Color.black, "Volvo240"); //Har tagit bort parametrarna x,y & direction.

    @Test
    void speedFactor() {
        assertEquals(100*0.01*1.25, Volvo240.speedFactor(), "Speed factor should be 1%*1.25 of engine power.");
    }
}