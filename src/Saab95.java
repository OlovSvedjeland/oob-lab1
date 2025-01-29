import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn;

    // Standardkonstruktor
    public Saab95() {
        this(2, Color.red, 125, false, 0, "Saab95",0 ,0, 0);
    }

    //Anpassningsbar Konstruktor
    public Saab95(int nrDoors,Color color, double enginePower, boolean turboOn, double currentSpeed, String modelName, double x, double y, int direction){
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y, direction);
        this.turboOn = turboOn;
    }

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
        return getEnginePower() * 0.01 * turbo; //OCP med getter metod
    }
}

