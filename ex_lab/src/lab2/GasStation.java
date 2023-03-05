package lab2;

public class GasStation {
    private String name;
    private float x;
    private float y;
    private float price;

    public GasStation(String name, float x, float y, float price) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[GasStation] " +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", price=" + price;
    }
}
