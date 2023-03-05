package lab2;

import lab1.lab1;

public class lab2 {
    public static void main(String[] args) {
        lab2 lab2 = new lab2();
        //lab2.compulsory();
        lab2.homework();
    }

    void compulsory() {
        Road road1 = new Road("E85", RoadType.EXPRESS, 240, 120);
        System.out.println(road1.toString());

        Road road2 = new Road("DJ23", RoadType.RURAL, 100, 50);
        System.out.println(road2.toString());

        Road road3 = new Road("A7", RoadType.HIGHWAY, 250, 200);
        System.out.println(road3.toString());

        Location l1 = new Location("Petrom Bicaz", LocationType.GAS_STATION, 1, 10);
        System.out.println(l1.toString());

        Location l2 = new Location("Iasi - Henri Coanda", LocationType.AIRPORT, 20, 30);
        System.out.println(l2.toString());

        Location l3 = new Location("Iasi", LocationType.CITY, 19, 25);
        System.out.println(l3.toString());

        Location l4 = new Location("Bicaz", LocationType.CITY, 1, 12);
        System.out.println(l4.toString());

    }

    void homework(){
        Problem pb = new Problem();
        Location l1 = new Location("Petrom Bicaz", LocationType.GAS_STATION, 1, 10);
        System.out.println(l1.toString());
        pb.addLocation(l1);
        System.out.println(pb.toString());
    }
}