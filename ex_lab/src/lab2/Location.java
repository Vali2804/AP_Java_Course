package lab2;
public class Location {
    private String name;
    private float x;
    private float y;
    private LocationType type;

    public Location(String name, LocationType type, float x, float y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[Location] " +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y;
    }
}
