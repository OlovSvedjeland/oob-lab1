import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25; //unik för Volvo240 /einar

    public Volvo240() {
        this(4, 100, 0, Color.black, "Volvo240", 0, 0, 0);
    }

    public Volvo240(int nrDoors, double enginePower,double currentSpeed, Color color, String modelName, double x, double y, int direction) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y, direction);
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

