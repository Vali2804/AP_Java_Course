package lab2;

import lab1.lab1;

public class lab2 {
    public static void main(String[] args) {
        lab2 lab2 = new lab2();
        //lab2.compulsory();
        lab2.homework();
    }

//    void compulsory() {
//        Road road1 = new Road("E85", RoadType.EXPRESS, 240, 120);
//        System.out.println(road1.toString());
//
//        Road road2 = new Road("DJ23", RoadType.RURAL, 100, 50);
//        System.out.println(road2.toString());
//
//        Road road3 = new Road("A7", RoadType.HIGHWAY, 250, 200);
//        System.out.println(road3.toString());
//
//        Location l1 = new Location("Petrom Bicaz", LocationType.GAS_STATION, 1, 10);
//        System.out.println(l1.toString());
//
//        Location l2 = new Location("Iasi - Henri Coanda", LocationType.AIRPORT, 20, 30);
//        System.out.println(l2.toString());
//
//        Location l3 = new Location("Iasi", LocationType.CITY, 19, 25);
//        System.out.println(l3.toString());
//
//        Location l4 = new Location("Bicaz", LocationType.CITY, 1, 12);
//        System.out.println(l4.toString());
//
//    }

    void homework(){
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
        //System.out.println(pb);
//        Highway r1 = new Highway("A7",30,150);
//        System.out.println(r1.toString());
//        Express r2 = new Express("E85",15,110);
//        System.out.println(r2.toString());
//        Country r3 = new Country("DJ10",5,50);
//
//        City l1 = new City("Iasi",5,20,150_000);
//        System.out.println(l1.toString());
//        Airport l2 = new Airport("Henri Coanda Iasi",4,22,5);
//        System.out.println(l2.toString());
//        GasStation l3 = new GasStation("Petrom Bicaz", (float) 20,(float) 100, (float) 7.23);
//        System.out.println(l3.toString());
        Problem pb = new Problem();
        pb.addLocation(l1);
        System.out.println(pb.toString());
    }
}