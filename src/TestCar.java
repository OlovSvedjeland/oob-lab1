import java.awt.*;

class TestCar extends Car {
    public TestCar(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, double direction) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    @Override
    public double speedFactor() { // Enkel implementation för test
        return getEnginePower() * 0.01;
    }
}
