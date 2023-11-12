package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Entity(name = "final_rate_constraint_config")
@EntityListeners(BaseEntityListener.class)
public class FinalRateConstraintConfig extends BaseEntity{

    private  RuleAssignment ruleAssignment;
    private  double minMileage;
    private  double maxMileage;
    private double targetPay;
    private  double maxBuy;
    private List<Integer> rateEquipmentTypes;

    @Transient
    public List<Integer> getRateEquipmentTypes() {
        return rateEquipmentTypes;
    }

    public void setRateEquipmentTypes(List<Integer> rateEquipmentTypes) {
        this.rateEquipmentTypes = rateEquipmentTypes;
    }

    @JoinColumn(name = "rule_assignment_id")
    @ManyToOne(fetch = FetchType.EAGER)
    public RuleAssignment getRuleAssignment() {
        return ruleAssignment;
    }
    @Column(name = "min_mileage")
    public double getMinMileage() {
        return minMileage;
    }
    @Column(name = "max_mileage")
    public double getMaxMileage() {
        return maxMileage;
    }

    @Column(name = "target_pay")
    public double getTargetPay() {
        return targetPay;
    }
    @Column(name ="max_buy" )
    public double getMaxBuy() {
        return maxBuy;
    }

    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }

    public void setMinMileage(double minMileage) {
        this.minMileage = minMileage;
    }

    public void setMaxMileage(double maxMileage) {
        this.maxMileage = maxMileage;
    }

    public void setTargetPay(double targetPay) {
        this.targetPay = targetPay;
    }

    public void setMaxBuy(double maxBuy) {
        this.maxBuy = maxBuy;
    }

    public FinalRateConstraintConfig(RuleAssignment ruleAssignment, double minMileage, double maxMileage, double targetPay, double maxBuy) {
        this.ruleAssignment = ruleAssignment;
        this.minMileage = minMileage;
        this.maxMileage = maxMileage;
        this.targetPay = targetPay;
        this.maxBuy = maxBuy;
    }
}
