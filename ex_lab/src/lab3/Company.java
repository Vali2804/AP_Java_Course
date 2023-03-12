package lab3;

import java.util.*;

public class Company implements Node, Comparable<Company> {
    private String name;
    private String industry;
    private Map<String, Node> connections;

    public Company(String name, String industry) {
        this.name = name;
        this.industry = industry;
        this.connections = new HashMap<>();
    }

    public void addConnection(String relationship, Node connection) {
        this.connections.put(relationship, connection);
    }

    public Map<String, Node> getConnections() {
        return this.connections;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public int compareTo(Company other) {

        return this.name.compareTo(other.name);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    @Override
    public String toString() {
        return "[Company] " +
                "name='" + name + '\'' +
                ", industry='" + industry + '\'';
    }
}
