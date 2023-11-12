package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.entities.misc.GeoCityGeoZipId;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "geo_city_geo_zip")
@IdClass(GeoCityGeoZipId.class)
@Data
public class GeoCityGeoZip {

    @Id
    @Column(name = "city_name")
    private String cityName;

    @Id
    @Column(name = "state_code")
    private String stateCode;

    @Id
    @JoinColumn(name = "zip_code")
    @ManyToOne(fetch = FetchType.LAZY)
    private GeoZip zipCode;

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "is_zip_primary_city")
    private boolean isZipPrimaryCity;


    private String createdUserid;
    private String updatedUserid;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Column(name = "created_userid", nullable = false)
    public String getCreatedUser() {
        return createdUserid;
    }

    @Column(name = "updated_userid", nullable = false)
    public String getUpdatedUser() {
        return updatedUserid;
    }

}
