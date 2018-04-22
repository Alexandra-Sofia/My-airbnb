package servlets;

/**
 * Created by alex on 28/6/2017.
 */

import db.PersistenceManager;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Dates",query="Select c from Calendar c WHERE c.listing_id LIKE :custId")
@Table(name="calendar")
public class Calendar  {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="listing_id")
    private int listing_id;
    @Column(name="date")
    private  String date;
    @Column(name="available")
    private String available;
    @Column(name="price")
    private String price;

    public String getPrice() {
        return price;
    }

    public int getListing_id() {
        return listing_id;
    }

    public String getAvailable() {
        return available;
    }

    public String getDate() {
        return date;
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

    public List<Calendar> getDates(){
        List<Calendar> dates;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        dates=em.createNamedQuery("Dates").getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return dates;
    }

}
