package entities;

import db.PersistenceManager;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alexandra on 25/4/2017.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Validate", query = "SELECT u FROM User u where u.username = :custName and u.password = :custPass"),
        @NamedQuery(name = "Unique", query = "SELECT u FROM User u where u.username = :custName"),
        @NamedQuery(name = "All", query = "SELECT u FROM User u")
        /*@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.name = :firstname"),
        @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
        @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")*/
})
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="firstname")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="telephone")
    private String telephone;
    @Column(name="host_id")
    private int host_id;
    @Column(name="admin")
    Boolean admin;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getHost_id() {
        return host_id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.name = firstName;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin(Boolean admin) {
        return admin;
    }

    public List<User> getValidation(String username, String password){
        List<User> user;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        user=em.createNamedQuery("Validate").setParameter("custName", username).setParameter("custPass", password).getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return user;
    }

    public List<User> getUnique(String username){
        List<User> user;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        user=em.createNamedQuery("Unique").setParameter("custName", username).getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return user;
    }

    public List<User> getAllUsers(){
        List<User> users;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        users=em.createNamedQuery("All").getResultList();

        em.getTransaction().commit();
        em.close();
        /*PersistenceManager.INSTANCE.close();*/
        return users;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        /*if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
    }



}
