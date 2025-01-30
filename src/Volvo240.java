import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25; // Unikt trimvärde för Volvo

    // Standardvolvo240
    public Volvo240() {
        this(4, 100, 0, Color.black, "Volvo240");
    }

    public Volvo240(int nrDoors, double enginePower,double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    } // Konstruktor där x, y och direction får standardvärden

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    } // Implementering av speedfactor
}

