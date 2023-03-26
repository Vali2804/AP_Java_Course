package Lab5;

import javax.print.Doc;
import java.io.IOException;
import java.net.URISyntaxException;

public class Lab5 {
    public static void main(String[] args){
        Lab5 app = new Lab5();
        try{
            app.testCreateSave();
            app.testList();
            app.testReport();
            app.testLoadView();
        }catch (Exception e) {
            System.out.println("Eroare:" + e);
        }
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("book1","123","123");
        var article = new Document("article1","asb","d:/research/asb.txt");
        var book1 = new Document("book2","123asd","daw");
        catalog.add(book);
        catalog.add(article);
        catalog.add(book1);
        CatalogUtil.save(catalog, "d:/research/catalog.json");
    }
    private void testLoadView() throws IOException, URISyntaxException, InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
        CatalogUtil.view(catalog.findById("article1"));
    }
    private void testList() throws IOException, URISyntaxException, InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
        catalog.list();
    }

    private void testReport() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
        catalog.report();
    }
}
