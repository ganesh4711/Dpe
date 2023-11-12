package com.imaginnovate.dpe.data.domain;

import com.imaginnovate.dpe.entities.Accessorial;
import com.imaginnovate.dpe.entities.ApplicationUser;
import lombok.Data;

import java.util.Date;

@Data
public class AccessorialDTO {
    private long id;

    private String name;
    private String code;

    private ApplicationUser createdUser;

    private ApplicationUser updatedUser;

    private Date createdAt;

    private Date updatedAt;
    private Date deletedAt;
    public AccessorialDTO(Accessorial accessorial){
        this.id=accessorial.getId();
        this.name=accessorial.getName();
        this.code=accessorial.getCode();
        this.createdAt=accessorial.getCreatedAt();
        this.createdUser=accessorial.getCreatedUser();
        this.updatedAt=accessorial.getUpdatedAt();
        this.updatedUser=accessorial.getUpdatedUser();
        this.deletedAt=accessorial.getDeletedAt();
    }

}
