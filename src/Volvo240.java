import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25; //unik för Volvo240 /einar

    public Volvo240() {
        this(4, 100, 0, Color.black, "Volvo240"); //Har tagit bort parametrarna x,y & direction.
    } //Vi kan nog ta bort x, y och direction?

    public Volvo240(int nrDoors, double enginePower,double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName); //Har tagit bort parametrarna x,y & direction.
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

