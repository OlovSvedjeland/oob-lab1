import java.awt.*;

class TestCar extends Car {
    public TestCar(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, double direction) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01; // Enkel implementation för test
    }
}
