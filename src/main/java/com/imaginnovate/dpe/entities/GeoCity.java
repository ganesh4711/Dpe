package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.entities.misc.GeoCityId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Entity
@Table(name = "geo_city")
@IdClass(GeoCityId.class)
@EqualsAndHashCode(callSuper=false)
@Data
public class GeoCity {

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "state_code")
    private String stateCode;

    @Id
    @Column(name = "country_code")
    private String countryCode;

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
    public String getCreatedUserid() {
        return createdUserid;
    }

    @Column(name = "updated_userid", nullable = false)
    public String getUpdatedUserid() {
        return updatedUserid;
    }


}


