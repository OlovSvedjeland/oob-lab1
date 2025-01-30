import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private double x;
    private double y;
    private int direction;

    protected Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;

        // Hanterar om vi konstruerar med fel parametrar & kastar error vid fel
        if (nrDoors < 1) { throw new IllegalArgumentException("Car cannot have less than 1 door.");}
        if (enginePower <= 0) { throw new IllegalArgumentException("Enginepower must be positive.");}
        if (currentSpeed < 0 || currentSpeed > enginePower) {
            throw new IllegalArgumentException("Speed cannot exceed engine power or be les than 0");
        }
    }

    @Override
    public void move() {                // Gör så bilen förflyttas utefter vilken riktning den har
        switch (direction) {
            case 0 -> y += currentSpeed; // Förflyttning "framåt"
            case 1 -> x += currentSpeed; // Förflyttning Höger
            case 2 -> y -= currentSpeed; // Förflyttning Ner
            case 3 -> x -= currentSpeed; // Förflyttning Vänster
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4; // Vänder moturs med mod 4 p.g.a endast fyra riktningar
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4; // Vänder medurs med mod 4 p.g.a endast fyra riktningar
    }



    public void gas(double amount){     // Höjer current speed
        if (amount < 0 || amount > 1) { // Sanity check för att dubbelkolla ogiltiga inputs
            throw new IllegalArgumentException("Amount of Gas must be more than 0 and less than 1.");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){   // Sänker current speed
        if (amount < 0 || amount > 1) { // Sanity check för att dubbelkolla ogiltig input
            throw new IllegalArgumentException("Amount of Break must be more than 0 and less than 1.");
        }
        decrementSpeed(amount);
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    //Nedan ligger alla getter & setter metoder.
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public Color getColor(){
        return color;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public void setColor(Color clr){
        color = clr;
    }




    protected final double getEnginePower(){
        return enginePower;
    } // För att få åtkomst till private instanstvariabel

    protected final double getCurrentSpeed(){
        return currentSpeed;
    } // För att få åtkomst till private instanstvariabel

    protected abstract double speedFactor(); // Abstrakt då subklasserna har olika implementationer

    protected void incrementSpeed(double amount) { // Höjer hastigheten med hänsyn till enginePower
        currentSpeed = Math.min(currentSpeed + getCurrentSpeed() * amount, enginePower);
    }
    // Enbart protected så att subklasser kan ändra acceleration. Kan göras privat och gå via gas() istället

    protected void decrementSpeed(double amount) { // Sänker hastigheten med hänsyn till enginePower
        currentSpeed = Math.max(currentSpeed - getCurrentSpeed() * amount, 0);
    }
    // Enbart protected så att subklasser kan ändra deacceralation.

}