package entities;

/**
 * Created by Alexandra on 25/4/2017.
 */

/*import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;*/

public class Apartment {
    /*id,name,place,rooms,price,availability*/
    private int id;
    private String name;
    private String location;
    private int rooms;
    private int price;
    private boolean avail;

    public void init(){
        id=0;
        name="First /'n/' best";
        location="First /'n/' Amistad";
        rooms=3;
        price=777;
        avail=true;
    }
    //-----------------------------------------------
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() { return location; }
    public int getRooms() {
        return rooms;
    }
    public int getPrice() {
        return price;
    }
    public boolean getAvail() { return avail; }
    //-----------------------------------------------
}
