package entities;

import db.PersistenceManager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alex on 8/6/2017.
 */
/*PK: PRIMARY KEY  NN: NOT NULL     UQ: UNIQUE INDEX
 BIN: BINARY       UN: UNSIGNED     ZF: ZEROFILL
 AI: AUTO_INCREMENT  G: Generated Column*/
@Entity //while writing queries you have to use the name given in @Entity
@NamedQueries({
        @NamedQuery(name = "TopRated", query = "Select l from Listing l order by l.review_scores_rating desc"),
        @NamedQuery(name = "DbPlaces", query = "SELECT distinct l.city FROM Listing l"),
        @NamedQuery(name = "MostGuests", query = "SELECT l.guests FROM Listing l"),
        @NamedQuery(name = "SearchResults", query = "SELECT l FROM Listing l WHERE l.city LIKE CONCAT('%',:city,'%')"),
        @NamedQuery(name = "GetListing", query = "SELECT l FROM Listing l WHERE l.id = :id")
})
@Table(name="listings") //actual db name
public class Listing implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="scrape_id")
    private long scrape_id;
    @Column(name = "last_scraped")
    private String last_scraped;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="summary")
    private String summary;
    @Column(name="description",nullable=false)
    private String description;
    @Column(name="experiences_offered")
    private String ex_offered;
    @Column(name="neighborhood_overview")
    private String neighb_overview;
    @Column
    private String notes;
    @Column(name="transit")
    private String transit;
    @Column(name="thumbnail_url")
    private String thumbnail;
    @Column(name="medium_url")
    private String medium_url;
    @Column(name="picture_url")
    private String picture;
    @Column(name="xl_picture_url")
    private String xl_picture;

    /*@JoinTable(name="host")
    @OneToMany
    @JoinColumn(name="id")
    public Host host;*/

    @ManyToOne()
    private Host host;

    /*@Column(name="host_id")
    private int host;*/
    @Column(name="street")
    private String street;
    @Column(name="neighbourhood")
    private String neighb;
    @Column(name="neighbourhood_cleansed")
    private String neighC;
    @Column(name="neighbourhood_group_cleansed")
    private String neighbGC;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zipcode")
    private String zipcode;
    @Column(name="market")
    private String market;
    @Column(name="country_code")
    private String counrty_code;
    @Column(name="country")
    private String country;
    @Column(name="latitude")
    private double latitude;
    @Column(name="longitude")
    private double longitude;
    @Column(name="is_location_exact")
    private String is_location_exact;
    @Column(name="property_type")
    private String property_type;
    @Column(name="room_type")
    private String room_type;
    @Column(name="accommodates")
    private int accommodates;
    @Column(name="bathrooms")
    private double bathrooms;
    @Column(name="bedrooms")
    private int bedrooms;
    @Column(name="beds")
    private int beds;
    @Column(name="bed_type")
    private String bed_type;
    @Column(name="amenities")
    private String amenities;
    @Column(name="square_feet")
    private String square_feet;
    @Column(name="price")
    private String price;
    @Column(name="weekly_price")
    private String weekly_price;
    @Column(name="monthly_price")
    private String monthly_price;
    @Column(name="security_deposit")
    public String security_deposit;
    @Column(name="cleaning_fee")
    private String cleaning_fee;
    @Column(name="guests_included")
    private int guests;
    @Column(name="extra_people")
    private String extra;
    @Column(name="minimum_nights")
    private int min;
    @Column(name="maximum_nights")
    private int max;
    @Column(name="calendar_updated")
    private String calendar;
    @Column(name="has_availability")
    private String availability;
    @Column(name="availability_30")
    private int avail30;
    @Column(name="availability_60")
    private int avail60;
    @Column(name="availability_90")
    private int avail90;
    @Column(name="availability_365")
    private int avail365;
    @Column(name="calendar_last_scraped")
    private String cal_last_scraped;
    @Column(name="number_of_reviews")
    private int Nreviews;
    @Column(name="first_review")
    private String first_review;
    @Column(name="last_review")
    private String last_review;
    @Column(name="review_scores_rating")
    private int review_scores_rating;
    @Column(name="review_scores_accuracy")
    private int review_scores_accuracy;
    @Column(name="review_scores_cleanliness")
    private int review_scores_cleanliness;
    @Column(name="review_scores_checkin")
    private int review_scores_checkin;
    @Column(name="review_scores_communication")
    private int review_scores_communication;
    @Column(name="review_scores_location")
    private int review_scores_location;
    @Column(name="review_scores_value")
    private int review_scores_value;
    @Column(name="requires_license")
    private String requires_lisence;
    @Column(name="license")
    private String license;
    @Column(name="jurisdiction_names")
    private String jurisdiction_names;
    @Column(name="instant_bookable")
    private String instant_book;
    @Column(name="require_guest_profile_picture")
    private String guest_profile;
    @Column(name="require_guest_phone_verification")
    private String guest_phone;
    @Column(name="calculated_host_listings_count")
    private int host_listings;
    @Column(name="reviews_per_month")
    private double reviews_per_month;
    @Column(name="space")
    private String space;

    public List<Listing> getHomepageSuggestions(){
        List<Listing> work;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        work=em.createNamedQuery("TopRated").setMaxResults(12).getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return work;
    }

    public List<String> getSearchPlaces(){
        List<String> places;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        places=em.createNamedQuery("DbPlaces").getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return places;
    }

    public List<Listing> getSearchListings(String page, String pageSize, String city, String dateFrom, String dateTo, String visitors){
        List<Listing> listings;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        listings=em.createNamedQuery("SearchResults")
                .setParameter("city", city)
                        //.setFirstResult(Integer.parseInt(page)*Integer.parseInt(pageSize))
                        //.setMaxResults(Integer.parseInt(pageSize))
                .getResultList();



        em.getTransaction().commit();
        em.close();

        return listings;
    }

    public List<Listing> getListing(String id){
        List<Listing> listing;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        listing=em.createNamedQuery("GetListing").setParameter("id", Integer.parseInt(id)).getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return listing;
    }
    public List<Integer> getMostGuests(){
        List<Integer> places;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        places=em.createNamedQuery("MostGuests").setMaxResults(1).getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return places;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

        public long getScrape_id() {
        return scrape_id;
    }

    public String getDescription() {
        return description;
    }

    public String getEx_offered() {
        return ex_offered;
    }

    public String getLast_scraped() {
        return last_scraped;
    }

    public Host getHost() {
        return host;
    }

    public String getPicture() {
        return picture;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getSummary() {
        return summary;
    }

    public String getNeighb() {
        return neighb;
    }

    public String getNeighb_overview() {
        return neighb_overview;
    }

    public String getCity() {
        return city;
    }

    public String getCounrty_code() {
        return counrty_code;
    }

    public String getNeighbGC() {
        return neighbGC;
    }

    public String getMarket() {
        return market;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCountry() {
        return country;
    }

    public String getProperty_type() {
        return property_type;
    }

    public String getNotes() {
        return notes;
    }

    public String getNeighC() {
        return neighC;
    }

    public String getStreet() {
        return street;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getState() {
        return state;
    }

    public String getIs_location_exact() {
        return is_location_exact;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getTransit() {
        return transit;
    }

    public String getXl_picture() {
        return xl_picture;
    }

    public String getZipcode() {
        return zipcode;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getAvail30() {
        return avail30;
    }

    public int getAvail60() {
        return avail60;
    }

    public int getBeds() {
        return beds;
    }

    public int getGuests() {
        return guests;
    }

    public int getMax() {
        return max;
    }

    public String getAmenities() {
        return amenities;
    }

    public int getMin() {
        return min;
    }

    public int getAvail90() {
        return avail90;
    }

    public String getBed_type() {
        return bed_type;
    }

    public String getPrice() {
        return price;
    }

    public int getAvail365() {
        return avail365;
    }

    public int getNreviews() {
        return Nreviews;
    }

    public double getReviews_per_month() {
        return reviews_per_month;
    }

    public String getCleaning_fee() {
        return cleaning_fee;
    }

    public String getExtra() {
        return extra;
    }

    public String getMonthly_price() {
        return monthly_price;
    }

    public String getSecurity_deposit() {
        return security_deposit;
    }

    public String getSquare_feet() {
        return square_feet;
    }

    public int getHost_listings() {
        return host_listings;
    }

    public String getWeekly_price() {
        return weekly_price;
    }

    public int getReview_scores_accuracy() {
        return review_scores_accuracy;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCalendar() {
        return calendar;
    }

    public int getReview_scores_checkin() {
        return review_scores_checkin;
    }

    public int getReview_scores_cleanliness() {
        return review_scores_cleanliness;
    }

    public int getReview_scores_communication() {
        return review_scores_communication;
    }

    public int getReview_scores_location() {
        return review_scores_location;
    }

    public int getReview_scores_rating() {
        return review_scores_rating;
    }

    public int getReview_scores_value() {
        return review_scores_value;
    }

    public String getCal_last_scraped() {
        return cal_last_scraped;
    }

    public String getFirst_review() {
        return first_review;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    public String getGuest_profile() {
        return guest_profile;
    }

    public String getInstant_book() {
        return instant_book;
    }

    public String getJurisdiction_names() {
        return jurisdiction_names;
    }

    public String getLast_review() {
        return last_review;
    }

    public String getLicense() {
        return license;
    }

    public String getRequires_lisence() {
        return requires_lisence;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEx_offered(String ex_offered) {
        this.ex_offered = ex_offered;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLast_scraped(String last_scraped) {
        this.last_scraped = last_scraped;
    }

    public void setScrape_id(long scrape_id) {
        this.scrape_id = scrape_id;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMedium_url(String medium_url) {
        this.medium_url = medium_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNeighb(String neighb) {
        this.neighb = neighb;
    }

    public void setCounrty_code(String counrty_code) {
        this.counrty_code = counrty_code;
    }

    public void setNeighb_overview(String neighb_overview) {
        this.neighb_overview = neighb_overview;
    }

    public void setNeighbGC(String neighbGC) {
        this.neighbGC = neighbGC;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setNeighC(String neighC) {
        this.neighC = neighC;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public void setXl_picture(String xl_picture) {
        this.xl_picture = xl_picture;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setIs_location_exact(String is_location_exact) {
        this.is_location_exact = is_location_exact;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public void setAvail30(int avail30) {
        this.avail30 = avail30;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setAvail60(int avail60) {
        this.avail60 = avail60;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setAvail90(int avail90) {
        this.avail90 = avail90;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public void setAvail365(int avail365) {
        this.avail365 = avail365;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setCal_last_scraped(String cal_last_scraped) {
        this.cal_last_scraped = cal_last_scraped;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public void setSquare_feet(String square_feet) {
        this.square_feet = square_feet;
    }

    public void setCleaning_fee(String cleaning_fee) {
        this.cleaning_fee = cleaning_fee;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setFirst_review(String first_review) {
        this.first_review = first_review;
    }

    public void setWeekly_price(String weekly_price) {
        this.weekly_price = weekly_price;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }

    public void setGuest_profile(String guest_profile) {
        this.guest_profile = guest_profile;
    }

    public void setMonthly_price(String monthly_price) {
        this.monthly_price = monthly_price;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
    public void setHost_listings(int host_listings) {
        this.host_listings = host_listings;
    }

    public void setInstant_book(String instant_book) {
        this.instant_book = instant_book;
    }

    public void setJurisdiction_names(String jurisdiction_names) {
        this.jurisdiction_names = jurisdiction_names;
    }

    public void setLast_review(String last_review) {
        this.last_review = last_review;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setNreviews(int nreviews) {
        Nreviews = nreviews;
    }

    public void setRequires_lisence(String requires_lisence) {
        this.requires_lisence = requires_lisence;
    }

    public void setReview_scores_accuracy(int review_scores_accuracy) {
        this.review_scores_accuracy = review_scores_accuracy;
    }

    public void setReview_scores_checkin(int review_scores_checkin) {
        this.review_scores_checkin = review_scores_checkin;
    }

    public void setReview_scores_cleanliness(int review_scores_cleanliness) {
        this.review_scores_cleanliness = review_scores_cleanliness;
    }

    public void setReview_scores_communication(int review_scores_communication) {
        this.review_scores_communication = review_scores_communication;
    }

    public void setReview_scores_location(int review_scores_location) {
        this.review_scores_location = review_scores_location;
    }

    public void setReview_scores_rating(int review_scores_rating) {
        this.review_scores_rating = review_scores_rating;
    }

    public void setReview_scores_value(int review_scores_value) {
        this.review_scores_value = review_scores_value;
    }

    public void setSecurity_deposit(String security_deposit) {
        this.security_deposit = security_deposit;
    }

    public void setReviews_per_month(double reviews_per_month) {
        this.reviews_per_month = reviews_per_month;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String InsertListing(String name, String listing_url, String country, String zipcode, String neighborhood_cleansed,
                                String price, String weekly_price, String monthly_price, String security_deposit, String cleaning_fee,
                                String guests_included, String extra_people, String minimum_nights, String maximum_nights,
                                String cancellation_policy, String property_type, String room_type, String accommodates,
                                String bathrooms, String bedrooms, String beds, String bed_type, String square_feet,
                                String amenities, String summary, String space, String description, String neighborhood_overview,
                                String notes, String transit){

        try {
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            em.getTransaction().begin();
            Listing listing = new Listing();

            /*name,listing_url,country,zipcode,neighborhood_cleansed,price,weekly_price,
                    monthly_price,security_deposit,cleaning_fee,guests_included,extra_people,minimum_nights,maximum_nights,
                    cancellation_policy,property_type,room_type,accommodates,bathrooms,bedrooms,beds,bed_type,square_feet,
                    amenities,summary,space,description,neighborhood_overview,notes,transit*/
            listing.setName(name);
            listing.setMedium_url(listing_url);
            listing.setCountry(country);
            listing.setSpace(space);
            listing.setDescription(description);

            em.persist(listing);

            em.getTransaction().commit();
            em.close();

            return "SUCCESS";
        }catch (Exception e){
            return "FAILURE";
        }

    }
}

