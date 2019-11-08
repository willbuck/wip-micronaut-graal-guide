package example.micronaut;

import java.io.Serializable;

public class Photo implements Serializable {
    private String id;
    private String photo_link;
    private String thumb_link;

    public Photo() {
    }

    public Photo(String id, String photo_link, String thumb_link) {
        this.id = id;
        this.photo_link = photo_link;
        this.thumb_link = thumb_link;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public String getThumb_link() {
        return thumb_link;
    }

    public void setThumb_link(String thumb_link) {
        this.thumb_link = thumb_link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
