import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    // Skapa en instans av TestCar
    TestCar car = new TestCar(4, 100, 0, Color.blue, "TestModel", 0, 0, 0);

    @Test
    void stopEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed()); // Kolla om startEngine fungerar
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed()); // Kolla om stopEngine fungerar
    }

    @Test
    void getNrDoors() {
        assertEquals(4, car.getNrDoors()); // Kolla om getter-metoden för Doors fungerar.
    }

    @Test
    void getEnginePower() {
        assertEquals(100, car.getEnginePower()); // Kolla om getter-metoden för EnginePower fungerar.
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0, car.getCurrentSpeed()); // Kolla om getter-metoden för CurrentSpeed fungerar.
    }

    @Test
    void speedFactor() {
        assertEquals(1, car.speedFactor()); // Kolla om getter-metoden för test-Speedfactor fungerar.
    }

    @Test
    void getColor() {
        assertEquals(Color.blue, car.getColor()); // Kolla om getter-metoden för Color fungerar.
    }

    @Test
    void setColor() {
        car.setColor(Color.red);
        assertEquals(Color.red, car.getColor()); // Kolla om setter-metoden för Color fungerar.
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed()); // Kolla om startEngine fungerar (igen).
    }

    @Test
    void incrementSpeed() {
        car.startEngine();
        double speedBefore = car.getCurrentSpeed(); // Lokal Variabel
        car.incrementSpeed(0.5); // Öka hastigheten
        assertTrue(car.getCurrentSpeed() > speedBefore); // Kolla om hastigheten ökar med increment speed
    }

    @Test
    void decrementSpeed() {
        car.startEngine();
        car.gas(1); // Öka hastigheten
        double speedBefore = car.getCurrentSpeed(); // Lokal Variabel
        car.decrementSpeed(0.5); // Minska hastigheten
        assertTrue(car.getCurrentSpeed() < speedBefore); // Kolla om decrementSpeed fungerar.
    }

    @Test
    void gas() {
        car.startEngine();
        double speedBefore = car.getCurrentSpeed(); // Lokal variabel
        car.gas(0.5);
        assertTrue(car.getCurrentSpeed() > speedBefore);
    }

    @Test
    void brake() {
        car.startEngine();
        car.gas(1); // Öka hastigheten
        double speedBefore = car.getCurrentSpeed(); // Lokal variabel
        car.brake(0.5); // Bromsa bilen
        assertTrue(car.getCurrentSpeed() < speedBefore); // Kolla så hastigheten minskar
        // Här hade man kunnat testa så vi inte går utanför speed intervallet
    }
}
