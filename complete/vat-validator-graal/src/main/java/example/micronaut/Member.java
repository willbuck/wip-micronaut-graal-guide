package example.micronaut;

import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String name;
    private Photo photo;

    public Member() {
    }

    public Member(String id, String name, Photo photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
