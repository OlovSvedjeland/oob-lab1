import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    // Standardvolvo240
    public Saab95() {
        this(2, Color.red, 125, false, 0, "Saab95");
    }

    public Saab95(int nrDoors,Color color, double enginePower, boolean turboOn, double currentSpeed, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.turboOn = turboOn;
    } // Konstruktor där x, y och direction får standardvärden

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    public boolean getTurbo() {
        return turboOn;
    }


    @Override
    public double speedFactor(){
        double turbo = turboOn ? 1.3 : 1.0;
        return getEnginePower() * 0.01 * turbo;
    } // Implementering av speedfactor
}

