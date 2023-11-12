package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "base_rate_constraint_config")
@EntityListeners(BaseEntityListener.class)
public class BaseRateConstraintConfig extends BaseEntity {

    private double targetPay;
    private double maxBuy;
    private RuleAssignment ruleAssignment;

    private List<Integer>  equipments;

    @Transient
    public List<Integer> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Integer> equipments) {
        this.equipments = equipments;
    }

    @Column(name = "target_pay")
    public double getTargetPay() {
        return targetPay;
    }

    public void setTargetPay(double targetPay) {
        this.targetPay = targetPay;
    }

    @Column(name = "max_buy")
    public double getMaxBuy() {
        return maxBuy;
    }

    public void setMaxBuy(double maxBuy) {
        this.maxBuy = maxBuy;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_assignment_id")
    public RuleAssignment getRuleAssignment() {
        return ruleAssignment;
    }

    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }

}
