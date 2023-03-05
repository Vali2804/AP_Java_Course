package lab2;

public class Airport {
    private String name;
    private float x;
    private float y;
    private int numberTerminals;

    public Airport(String name, float x, float y, int numberTerminals) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.numberTerminals = numberTerminals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getNumberTerminals() {
        return numberTerminals;
    }

    public void setNumberTerminals(int numberTerminals) {
        this.numberTerminals = numberTerminals;
    }

    @Override
    public String toString() {
        return "[Airport] " +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", numberTerminals=" + numberTerminals;
    }
}
