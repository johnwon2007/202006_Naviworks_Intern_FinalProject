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
@Table(name="Location")
public class Location implements Serializable {
    public Location() {
    }

    @Column(name="ID", nullable=false, length=20)
    @Id
    @GeneratedValue(generator="LOCATION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="LOCATION_ID_GENERATOR", strategy="native")
    private long id;

    @OneToOne(optional=false, targetEntity=Restaurant.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="RestaurantID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKLocation107378"))
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name="Province", nullable=true, length=255)
    private String province;

    @Column(name="Address", nullable=true, length=255)
    private String address;

    public void setId(long value) {
        this.id = value;
    }

    public long getId() {
        return id;
    }

    public long getORMID() {
        return getId();
    }

    public void setProvince(String value) {
        this.province = value;
    }

    public String getProvince() {
        return province;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getAddress() {
        return address;
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
