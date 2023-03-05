package lab2;

import java.util.List;

public class Problem {

    private List<Location> locations;
    private List<Road> roads;

    public Problem() {
        this.locations = locations;
        this.roads = roads;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public boolean addLocation(Location location){
        if (locations.contains(location)) {
            return false;
        }
        return locations.add(location);
    }

    public boolean addRoad(Road road){
        if(roads.contains(road)) {
            return false;
        }
        return roads.add(road);
    }

    @Override
    public String toString() {
        return "[Problem] " +
                "locations=" + locations +
                ", roads=" + roads;
    }
}
