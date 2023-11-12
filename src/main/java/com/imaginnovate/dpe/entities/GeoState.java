package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.entities.misc.GeoStateId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Entity
@Table(name = "geo_state")
@IdClass(GeoStateId.class)
@EqualsAndHashCode(callSuper=false)
@Data
public class GeoState {

    @Id
    @Column(name = "code")
    private String code;

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "name")
    private String name;

    private String createdUser;
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

    @Column(name = "created_userid", nullable = false)
    public String getCreatedUser() {
        return createdUser;
    }

    @Column(name = "updated_userid", nullable = false)
    public String getUpdatedUser() {
        return updatedUser;
    }
}
