package lab2;

public class City {
    private String name;
    private float x;
    private float y;
    private int population;

    public City(String name, float x, float y, int population) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.population = population;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "[City] " +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", population=" + population;
    }
}
