package Lab5;

import javax.print.Doc;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }
    public Catalog (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public void add(Document doc) {
        docs.add(doc);
    }
    public Document findById(String id){
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
    public void list(){
        for(Document doc : docs)
            System.out.println(doc.toString());
    }
    public void report() {
        try {
            String reportFilename = "catalog_report.html";
            PrintWriter writer = new PrintWriter(reportFilename, "UTF-8");

            writer.println("<html><head><title>Catalog Report</title></head><body>");

            writer.println("<h1>Catalog Report</h1>");

            writer.println("<table border=\"1\"><tr><th>ID</th><th>Name</th><th>Location</th>");
            for (Document doc : docs) {
                writer.println("<tr><td>" + doc.getId() + "</td><td>" + doc.getTitle() + "</td><td>" + doc.getLocation() + "</td></tr>");
            }
            writer.println("</table>");

            writer.println("</body></html>");

            writer.close();

            Desktop.getDesktop().browse(new File(reportFilename).toURI());
        } catch (IOException e) {
            System.err.println("Error generating report: " + e.getMessage());
        }
    }
}
