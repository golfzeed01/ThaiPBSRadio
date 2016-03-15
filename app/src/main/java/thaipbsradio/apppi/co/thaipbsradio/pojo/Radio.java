package thaipbsradio.apppi.co.thaipbsradio.pojo;

/**
 * Created by pipatpong on 3/7/16 AD.
 */
public class Radio {
    private int photo;
    private String name;
    private String description;

    public Radio(int photo, String name, String description) {
        this.photo = photo;
        this.name = name;
        this.description = description;


    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {

        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;

    }
}
