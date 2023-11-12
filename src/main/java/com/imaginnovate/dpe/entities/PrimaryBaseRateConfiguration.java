package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "primary_base_rate_configuration")
@EntityListeners(BaseEntityListener.class)
public class PrimaryBaseRateConfiguration extends BaseEntity {
    private  RuleAssignment ruleAssignment;
    private   double adjustmentValue;
    List<Integer> rateEquipmentTypes;

    @Transient
    public List<Integer> getRateEquipmentTypes() {
        return rateEquipmentTypes;
    }

    public void setRateEquipmentTypes(List<Integer> rateEquipmentTypes) {
        this.rateEquipmentTypes = rateEquipmentTypes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_assignment_id")
    public RuleAssignment getRuleAssignment() {
        return ruleAssignment;
    }

    @Column(name = "adjustment_value")
    public double getAdjustmentValue() {
        return adjustmentValue;
    }

    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }


    public void setAdjustmentValue(double adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }
}
