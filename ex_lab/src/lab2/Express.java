package lab2;

public class Express {
    private String name;
    private float lenght;
    private int speedLimit;

    public Express(String name, float lenght, int speedLimit) {
        this.name = name;
        this.lenght = lenght;
        this.speedLimit = speedLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "[Express] " +
                "name='" + name + '\'' +
                ", lenght=" + lenght +
                ", speedLimit=" + speedLimit;
    }
}
