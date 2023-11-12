package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accessorial_adjustment_configuration")
@EntityListeners(BaseEntityListener.class)
public class AccessorialAdjustmentConfig extends BaseEntity{

    private List<Long> accessorial;
    private RuleAssignment ruleAssignment;
    private RateOperator rateOperator;
    private List<Integer> equipments;
    private double adjustmentValue;

    @Transient
    public List<Long> getAccessorial() {
        return accessorial;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_assignment_id")
    public RuleAssignment getRuleAssignment() {
        return ruleAssignment;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_operator_id")
    public RateOperator getRateOperator() {
        return rateOperator;
    }

    @Transient
    public List<Integer> getEquipments() {
        return equipments;
    }

    @Column(name = "adjustment_value")
    public double getAdjustmentValue() {
        return adjustmentValue;
    }

    public void setAccessorial(List<Long> accessorial) {
        this.accessorial = accessorial;
    }

    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }

    public void setRateOperator(RateOperator rateOperator) {
        this.rateOperator = rateOperator;
    }

    public void setEquipments(List<Integer> equipments) {
        this.equipments = equipments;
    }

    public void setAdjustmentValue(double adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }
}
