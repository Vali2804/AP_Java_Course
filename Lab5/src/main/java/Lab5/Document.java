package Lab5;

import javax.print.Doc;
import java.io.Serializable;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location;
    private Map<String,String> tags;

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public Document() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public void addTag(String name, String value) {
        tags.put(name, value);
    }

    public String getTag(String name) {
        return tags.get(name);
    }

    @Override
    public String toString() {
        return "[Document] " +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags;
    }


}
