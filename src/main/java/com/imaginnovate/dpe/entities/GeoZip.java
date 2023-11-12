package com.imaginnovate.dpe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Entity
@Table(name = "geo_zip")
@EqualsAndHashCode(callSuper=false)
@Data
public class GeoZip {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "created_userid", nullable = false)
    private String createdUser;
    @Column(name = "updated_userid", nullable = false)
    private String updatedUser;

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

    public String getCreatedUser() {
        return createdUser;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

}
