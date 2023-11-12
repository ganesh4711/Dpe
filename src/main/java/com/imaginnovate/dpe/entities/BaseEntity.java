package com.imaginnovate.dpe.entities;


import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {


    private Long Id;
    private ApplicationUser createdUser;
    private ApplicationUser updatedUser;

    private Date createdAt;

    private Date updatedAt;

    private boolean deleted = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return Id;
    }

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }
    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_userid", nullable = true)
    public ApplicationUser getCreatedUser() {
        return createdUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_userid", nullable = true)
    public ApplicationUser getUpdatedUser() {
        return updatedUser;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setCreatedUser(ApplicationUser createdUser) {
        this.createdUser = createdUser;
    }

    public void setUpdatedUser(ApplicationUser updatedUser) {
        this.updatedUser = updatedUser;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
