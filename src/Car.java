import java.awt.*;

public abstract class Car implements Movable {

    protected int nrDoors;                     // Number of doors on the car
    protected double enginePower;              // Engine power of the car
    protected double currentSpeed;             // The current speed of the car
    protected Color color;                     // Color of the car
    protected String modelName;                // The car model name

    protected double x;
    protected double y;
    protected int direction;

    protected Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, double direction) {
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

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected abstract double speedFactor();

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + getCurrentSpeed() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(currentSpeed - getCurrentSpeed() * amount, 0);
    }

    protected void gas(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount of Gas must be more than 0 and less than 1.");
        }
        incrementSpeed(amount);
    }

    protected void brake(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount of Break must be more than 0 and less than 1.");
        }
        decrementSpeed(amount);
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


}