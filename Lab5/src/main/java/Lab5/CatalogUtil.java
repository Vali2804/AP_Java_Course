package Lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }
    public static void view(Document doc) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(doc.getLocation()));
    }


}
