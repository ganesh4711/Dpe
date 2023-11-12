package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "shipper_rate_configuration")
@EntityListeners(BaseEntityListener.class)
public class ShipperRateConfiguration extends BaseEntity{


    private RuleAssignment ruleAssignment;

    private RateOperator rateOperator;

    private double adjustmentValue;

    private List<Integer> equipments;

    @Transient
    public List<Integer> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Integer> equipments) {
        this.equipments = equipments;
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
    @Column(name = "adjustment_value")
    public double getAdjustmentValue() {
        return adjustmentValue;
    }

    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }

    public void setRateOperator(RateOperator rateOperator) {
        this.rateOperator = rateOperator;
    }

    public void setAdjustmentValue(double adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }
}
