package lab3;

import java.util.*;

public class Network {
    private List<Object> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Object node) {
        this.nodes.add(node);
    }

    public List<Object> getNodes() {
        return this.nodes;
    }

    public int getNodeImportance(Node node) {
        int count = 0;
        for (Object n : this.nodes) {
            if (n instanceof Person) {
                Person person = (Person) n;
                if (person.getConnections().containsValue(node)) {
                    count++;
                }
            } else if (n instanceof Company) {
                Company company = (Company) n;
                if (company.getConnections().containsValue(node)) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Object> getNodesByImportance() {
        List<Object> sortedNodes = new ArrayList<>(this.nodes);
        Collections.sort(sortedNodes, new Comparator<Object>() {
            public int compare(Object n1, Object n2) {
                int importance1 = getNodeImportance((Node) n1);
                int importance2 = getNodeImportance((Node) n2);
                return Integer.compare(importance2, importance1);
            }
        });
        return sortedNodes;
    }
}
