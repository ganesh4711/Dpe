package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accessorial_type")
@EntityListeners(BaseEntityListener.class)
public class AccessorialType extends BaseEntity{
    private  Rule rule;
    private Accessorial accessorial;
    private Long configId;
    private Date deletedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_id",nullable = false)
    public Rule getRule() {return rule;}
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accessorial_id")
    public Accessorial getAccessorial() {return accessorial;}
    @Column(name = "config_id")
    public Long getConfigId() {return configId;}
    @Column(name = "deleted_at",updatable = false,insertable = false)
    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setRule(Rule rule) {this.rule = rule;}

    public void setAccessorial(Accessorial accessorial) {this.accessorial = accessorial;}
    public void setConfigId(Long configId) {this.configId = configId;}
    public void setDeletedAt(Date deletedAt) {this.deletedAt = deletedAt;}
}
