package entities;

/**
 * Created by alex on 13/6/2017.
 */

import db.PersistenceManager;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.io.Serializable;
import java.util.ListIterator;

@Entity
@NamedQuery(name="AskforHost",query="Select h from Host h WHERE h.id LIKE :custId")
@Table(name="host")
public class Host {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="url")
    private String url;
    @Column(name="name")
    private String name;
    @Column(name="since")
    private String since;
    @Column(name="location")
    private String location;
    @Column(name="about")
    private String about;
    @Column(name="response_time")
    private String response_time;
    @Column(name="response_rate")
    private String response_rate;
    @Column(name="acceptance_rate")
    private String acceptance_rate;
    @Column(name="is_superhost")
    private String superhost;
    @Column(name="thumbnail_url")
    private String thumbnail_url;
    @Column(name="picture_url")
    private String picture_url;
    @Column(name="neighbourhood")
    private String neighbourhood;
    @Column(name="listings_count")
    private int listings_count;
    @Column(name="total_listings_count")
    private int total_listings_count;
    @Column(name="verifications")
    private String verifications;
    @Column(name="has_profile_pic")
    private String has_profile_pic;
    @Column(name="host_identity_verified")
    private String host_identity_verified;

    /*@JoinTable(name="listing")
    @OneToMany
    @JoinColumn(name="id")
    public List<Listing> listings;*/

    @OneToMany(mappedBy="host")
    private Collection<Listing> listing;


    public List<Host> getfromId(int id){
        List<Host> results;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        results=em.createNamedQuery("AskforHost").setParameter("custId", id).getResultList();

        em.getTransaction().commit();
        em.close();
        return results;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public String getAcceptance_rate() {
        return acceptance_rate;
    }

    public String getHas_profile_pic() {
        return has_profile_pic;
    }

    public String getHost_identity_verified() {
        return host_identity_verified;
    }

    public int getListings_count() {
        return listings_count;
    }

    public String getLocation() {
        return location;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public String getResponse_rate() {
        return response_rate;
    }

    public String getResponse_time() {
        return response_time;
    }

    public String getSince() {
        return since;
    }

    public String getSuperhost() {
        return superhost;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public int getTotal_listings_count() {
        return total_listings_count;
    }

    public String getUrl() {
        return url;
    }

    public String getVerifications() {
        return verifications;
    }

}
