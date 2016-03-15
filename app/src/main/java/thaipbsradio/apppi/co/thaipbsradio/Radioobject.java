package thaipbsradio.apppi.co.thaipbsradio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.security.Key;

/**
 * Created by pipatpong on 3/10/16 AD.
 */
public class Radioobject implements Serializable {

    private int id;
    private String thump;
    private String title;
    private String author;
    private String starttime;
    private String endtime;

    private static String Key_id = "id";
    private static String key_title = "title";
    private static String key_thumbnail = "thumbnail";
    private static String Key_author = "author";
    private static String Key_starttime = "startTime";
    private static String Key_endtime = "endTime";

    public  Radioobject(JSONObject result){


        try {
            setId(result.getInt(Key_id));
            setTitle(result.getString(key_title));
            setThump(result.getString(key_thumbnail));
            setAuthor(result.getString(Key_author));
            setStrattime(result.getString(Key_starttime));
            setEndtime(result.getString(Key_endtime));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThump() {
        return thump;
    }

    public void setThump(String thump) {
        this.thump = thump;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor (String author){
        this.author = author;

    }
    public String getStarttime(){
        return starttime;
    }
    public void setStrattime(String starttime){
        this.starttime = starttime;
    }
    public String getEndtime(){
        return endtime;
    }
    public void setEndtime(String endtime){
        this.endtime = endtime;
    }
}
