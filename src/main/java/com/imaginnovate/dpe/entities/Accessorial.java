package com.imaginnovate.dpe.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Entity(name = "accessors")
@EntityListeners(BaseEntityListener.class)
public class Accessorial extends BaseEntity {

    @Pattern(regexp = "^[^\\s]+$")
    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String code;

    private Date deletedAt;

    @Column(name = "accessorial_name")
    public String getName() {
        return name;
    }
    @Column(name = "code")
    public String getCode() {
        return code;
    }
    @Column(name = "deleted_at")
    public Date getDeletedAt() {
        return deletedAt;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }


}
