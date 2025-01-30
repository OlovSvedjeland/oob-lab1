import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors;                     // Number of doors on the car
    private double enginePower;              // Engine power of the car
    private double currentSpeed;             // The current speed of the car
    private Color color;                     // Color of the car
    private String modelName;                // The car model name
    private double x;
    private double y;
    private int direction;

    protected Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;

        if (nrDoors < 1) { throw new IllegalArgumentException("Car cannot have less than 1 door.");}
        if (enginePower <= 0) { throw new IllegalArgumentException("Enginepower must be positive.");}
        if (currentSpeed < 0 || currentSpeed > enginePower) {
            throw new IllegalArgumentException("Speed cannot exceed engine power or be les than 0");
        }
    }

    @Override
    public void move() {
        switch (direction) {
            case 0 -> y += currentSpeed; // Upp
            case 1 -> x += currentSpeed; // höger
            case 2 -> y -= currentSpeed; // ner
            case 3 -> x -= currentSpeed; // vänster
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4; //Vänder moturs
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4; //Vänder medurs
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount of Gas must be more than 0 and less than 1.");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) {
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
    } //För att få åtkomst till private instanstvariabel

    protected final double getCurrentSpeed(){
        return currentSpeed;
    } //För att få åtkomst till private instanstvariabel

    protected abstract double speedFactor(); // Abstrakt då subklasserna har olika implementationer

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + getCurrentSpeed() * amount, enginePower);
    } // Enbart protected så att subklasser kan ändra acceleration.

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(currentSpeed - getCurrentSpeed() * amount, 0);
    }// Enbart protected så att subklkasser kan ändra deacceralation.


}