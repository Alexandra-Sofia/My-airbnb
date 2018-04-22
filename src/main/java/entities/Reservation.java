package entities;

/**
 * Created by Alexandra on 25/4/2017.
 */


import db.PersistenceManager;
import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import entities.calendar;


@Entity
@NamedQueries({
    @NamedQuery(name = "IsAvailableListing", query = "Select SUM(1) from calendar b WHERE b.listing_id = :listing_id AND ( (date >= :dateFrom and date < :dateTo) OR (date < :dateFrom and date >= :dateTo) ) AND b.available = 't'"),
    @NamedQuery(name = "GetPriceForTimePeriod", query = "Select b.price from calendar b WHERE b.listing_id = :listing_id AND ( (date >= :dateFrom and date < :dateTo) OR (date < :dateFrom and date >= :dateTo) ) AND b.available = 't'"),
     /*@NamedQuery(name = "MakeReservation", query = "UPDATE calendar b set b.available = 'f' WHERE b.listing_id = :listing_id AND ((date >= :dateFrom and date < :dateTo)OR((date < :dateFrom and date >= :dateTo))) AND b.available = 't';INSERT INTO bookings (listing_id,user_id,dateFrom,dateTo,price) values(:listing_id,:user_id,:dateFrom,:dateTo,(Select SUM(REPLACE(price,'$','')) from calendar b WHERE b.listing_id = :listing_id AND ((date >= :dateFrom and date < :dateTo)OR((date < :dateFrom and date >= :dateTo))) AND b.available = 't'))"),*/
     @NamedQuery(name = "UpdateCalendarReservation", query = "UPDATE calendar set available = 'f' WHERE listing_id = :listing_id AND ((date >= :dateFrom and date < :dateTo)OR((date < :dateFrom and date >= :dateTo))) AND available = 't'"),
})
@Table(name="bookings")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id_booking", nullable = false)
    private int id;
    @Column(name="listing_id")
    private int listing_id;
    @Column(name="user_id")
    private int user_id;
    @Column(name="dateFrom")
    private String dateFrom;
    @Column(name="dateTo")
    private String dateTo;
    @Column(name="price")
    private String price;
    @Column(name="cancelled")
    private String cancelled;

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }

    public int getListing_id() {
        return listing_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getCancelled() {
        return cancelled;
    }

    public int getId() {
        return id;
    }

    public String MakeReservation( int listing_id, int user_id, String dateFrom, String dateTo, int numOfDays){

        try {
            String result = "FAILURE";
            List<String> Availability;
            List<String> Prices;
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            em.getTransaction().begin();

            /*reservationList = em.createNamedQuery("IsAvailableListing")
                    .setParameter("listing_id", listing_id)
                    .setParameter("user_id", user_id)
                    .setParameter("dateFrom", dateFrom)
                    .setParameter("dateTo", dateTo)
                    .getResultList();*/
            Availability = em.createNamedQuery("IsAvailableListing")
                    .setParameter("listing_id", listing_id)
                    .setParameter("dateFrom", dateFrom)
                    .setParameter("dateTo", dateTo)
                    .getResultList();
            /*String count = reservationList.get(0);*/
            /*int count = 333;*/
            /*if(count< 5){
                return "NOT_AVAILABLE";
            }*/
            Prices = em.createNamedQuery("GetPriceForTimePeriod")
                    .setParameter("listing_id", listing_id)
                    .setParameter("dateFrom", dateFrom)
                    .setParameter("dateTo", dateTo)
                    .getResultList();
            /*Reservation reservation = new Reservation();
            reservation.setDateFrom(dateFrom);
            reservation.setDateTo(dateTo);
            reservation.setListing_id(listing_id);
            reservation.setUser_id(user_id);
            reservation.setPrice(dateFrom);
            em.persist(reservation);*/
            /*if (reservationList.size() = Integer.parseInt(numOfDays)) {
                return "NOT_AVAILABLE";
            }*/

            /*em.createNamedQuery("MakeReservation")
                .setParameter("listing_id", listing_id)
                .setParameter("user_id", user_id)
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo);
*/
            int i = 0;
            double sum = 0.0;
            while(true){
                try{
                    sum+=Double.parseDouble(Prices.get(i).replace("$",""));
                    i++;
                }catch(Exception ex){
                    break;
                }

            }
            if(i<numOfDays) return "NOT_AVAILABLE";
            System.out.println("\n $$ CHECK HERE 2  " + user_id + "\n");
            Reservation reservation = new Reservation();
            reservation.setDateFrom(dateFrom);
            reservation.setDateTo(dateTo);
            reservation.setListing_id(listing_id);
            reservation.setUser_id(user_id);

            reservation.setPrice("$"+sum);
            em.persist(reservation);

            em.createNamedQuery("UpdateCalendarReservation")
                .setParameter("listing_id", listing_id)
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo)
                .executeUpdate();


            em.getTransaction().commit();
            em.close();
            /*return count + "";*/
            return "SUCCESS";

        } catch (Exception e) {
            System.out.println("\n\n\n\n\n\n\n"+ e +"\n\n\n\n\n\n\n\n\n");
            return e+"FAILURE";
        }
    }
}
