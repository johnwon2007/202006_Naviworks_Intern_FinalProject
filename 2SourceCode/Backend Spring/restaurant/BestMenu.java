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
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="BestMenu")
public class BestMenu implements Serializable {
    public BestMenu() {
    }

    @Column(name="ID", nullable=false, length=20)
    @Id
    @GeneratedValue(generator="BESTMENU_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="BESTMENU_ID_GENERATOR", strategy="native")
    private long id;

    @OneToOne(optional=false, targetEntity=Restaurant.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="RestaurantID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKBestMenu996222"))
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name="Name", nullable=true, length=255)
    private String name;

    @Column(name="Price", nullable=true, length=255)
    private String price;

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

    public void setPrice(String value) {
        this.price = value;
    }

    public String getPrice() {
        return price;
    }

    public void setRestaurant(Restaurant value) {
        this.restaurant = value;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
