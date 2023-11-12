package com.imaginnovate.dpe.entities;


import com.imaginnovate.dpe.utils.AuthUtils;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


import java.util.Date;

public class BaseEntityListener {

    @Inject
    AuthUtils authUtils;

    @PrePersist
    void preCreate(BaseEntity baseEntity) {
        try {

            baseEntity.setCreatedAt(new Date());
            baseEntity.setUpdatedAt(new Date());
            ApplicationUser applicationUser = authUtils.getLoggedInUser();
            if (applicationUser != null) {
                baseEntity.setCreatedUser(applicationUser);
            }

        } catch (Exception exception) {
            exception.getMessage();
        }
    }


    @PreUpdate
    void preUpdate(BaseEntity baseEntity) {
        try {
            ApplicationUser applicationUser = authUtils.getLoggedInUser();
            baseEntity.setUpdatedAt(new Date());
            if (applicationUser != null) {
                baseEntity.setCreatedUser(applicationUser);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
