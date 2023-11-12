package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.common.Enums.EquipmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rate_equipment_type")
@EntityListeners(BaseEntityListener.class)
public class RateEquipmentType extends  BaseEntity{

    private Rule rule;

    private Long rateConfigId;


    private EquipmentType equipmentType;

    private Date deletedAt;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_id",nullable = false)
    public Rule getRule() {
        return rule;
    }

    @Column(name = "rate_config_id")
    public Long getRateConfigId() {
        return rateConfigId;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "equipment_type")
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    @Column(name = "deleted_at",updatable = false,insertable = false)
    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setRateConfigId(Long rateConfigId) {
        this.rateConfigId = rateConfigId;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
