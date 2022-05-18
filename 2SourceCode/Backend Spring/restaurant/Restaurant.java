package com.example.goodfood.restaurant;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Naviworks11
 * License Type: Purchased
 */
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Data
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Restaurant")
public class Restaurant implements Serializable {
    public Restaurant() {
    }

    @Column(name="ID", nullable=false, length=20)
    @Id
    @GeneratedValue(generator="RESTAURANT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="RESTAURANT_ID_GENERATOR", strategy="native")
    private long id;

    @Column(name="Name", nullable=true, length=255)
    private String name;

    @Column(name="Rating", nullable=true, length=10)
    private long rating;

    @Column(name="Information", nullable=true, length=255)
    private String information;

    @Column(name="Imagelink", nullable=true, length=1024)
    private String imagelink;

    @OneToOne(mappedBy="restaurant", targetEntity=BestMenu.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})
    private BestMenu bestMenu;

    @OneToOne(mappedBy="restaurant", targetEntity=Location.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})
    private Location location;

    public void setId(long value) {
        this.id = value;
    }

    public long getId() {
        return id;
    }

    public long getORMID() {
        return getId();
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }

    public void setRating(long value) {
        this.rating = value;
    }

    public long getRating() {
        return rating;
    }

    public void setInformation(String value) {
        this.information = value;
    }

    public String getInformation() {
        return information;
    }

    public void setBestMenu(BestMenu value) {
        this.bestMenu = value;
    }

    public BestMenu getBestMenu() {
        return bestMenu;
    }

    public void setLocation(Location value) {
        this.location = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setImagelink(String value) {
        this.imagelink = value;
    }

    public String getImagelink() {
        return imagelink;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
