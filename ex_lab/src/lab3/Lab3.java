package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.compulsory();
    }

    void compulsory() {
        Programmer p1 = new Programmer("Vali", "28.04.2002", "Java");
        Programmer p2 = new Programmer("Paul", "20.02.2001", "Python");
        Designer d1 = new Designer("Cata", "06.01.2003", "Photoshop");
        Designer d2 = new Designer("Raluca","03.08.2000", "Illustrator");
        Company c1 = new Company("Bit", "Anti-Malware");
        Company c2 = new Company("Abc", "Web-design");
        p1.addConnection("works for", c1);
        p2.addConnection("works for", c1);
        p1.addConnection("friend with", p2);
        p2.addConnection("firend with", p1);
        d1.addConnection("works for", c2);
        d2.addConnection("work for", c2);
        c1.addConnection("has employee", p2);
        c1.addConnection("has employee", p1);
        c2.addConnection("has employee", d1);
        c2.addConnection("has employee", d2);
        Network network = new Network();
        network.addNode(p1);
        network.addNode(p2);
        network.addNode(d1);
        network.addNode(d2);
        network.addNode(c1);
        network.addNode(c2);
        List<Object> sortedNodes = network.getNodesByImportance();
        for (Object node : sortedNodes) {
            System.out.println(node + " (importance: " + network.getNodeImportance((Node) node) + ")");
        }
    }
}

