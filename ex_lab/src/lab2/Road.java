package lab2;
public class Road {
    private String name;
    private RoadType type;
    private float lenght;
    private int speedLimit;

    public Road(String name, RoadType type, float lenght, int speedLimit) {
        this.name = name;
        this.type = type;
        this.lenght = lenght;
        this.speedLimit = speedLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
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
        return "[Road] " +
                "name='" + name + '\'' +
                ", type=" + type +
                ", lenght=" + lenght +
                ", speedLimit=" + speedLimit;
    }

}
