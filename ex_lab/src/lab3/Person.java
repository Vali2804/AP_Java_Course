package lab3;

import java.util.*;

public class Person implements Node, Comparable<Person> {
    private String name;
    private String birthDate;
    private Map<String, Node> connections;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.connections = new HashMap<>();
    }

    public void addConnection(String relationship, Node connection) {
        this.connections.put(relationship, connection);
    }

    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Map<String, Node> getConnections() {
        return this.connections;
    }

    @Override
    public String toString() {
        return "[Person]" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", connections=" + connections +
                '}';
    }


}
