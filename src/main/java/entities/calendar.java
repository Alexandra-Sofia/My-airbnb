package entities;




import db.PersistenceManager;
import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name="calendar")
public class calendar {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "available")
    private String available;
    @Column(name="listing_id")
    private int listing_id;
    @Column(name="price")
    private String price;
    @Column(name="date")
    private String date;

    public int getListing_id() {
        return listing_id;
    }

    public String getAvailable() {
        return available;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
