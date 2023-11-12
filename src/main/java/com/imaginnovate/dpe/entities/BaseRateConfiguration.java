package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.common.Enums.RateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "base_rate_configuration")
@EntityListeners(BaseEntityListener.class)
public class BaseRateConfiguration extends  BaseEntity{

    private   RuleAssignment ruleAssignment;

    private   RateOperator rateOperator;

    private RateType applicableForRateType;

    private List<RateEquipmentType> rateEquipmentTypes;

    private List<BaseRateSetting> rateSettings;

    @Transient
    public List<RateEquipmentType> getRateEquipmentTypes() {
        return rateEquipmentTypes;
    }

    public void setRateEquipmentTypes(List<RateEquipmentType> rateEquipmentTypes) {
        this.rateEquipmentTypes = rateEquipmentTypes;
    }

    @Transient
    public List<BaseRateSetting> getRateSettings() {
        return rateSettings;
    }

    public void setRateSettings(List<BaseRateSetting> rateSettings) {
        this.rateSettings = rateSettings;
    }

    @Column(name = "applicable_for_rate_type")
    @Enumerated(EnumType.ORDINAL)
    public RateType getApplicableForRateType() {
        return applicableForRateType;
    }

    public void setApplicableForRateType(RateType applicableForRateType) {
        this.applicableForRateType = applicableForRateType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_assignment_id", nullable = false)
    public RuleAssignment getRuleAssignment(){
     return ruleAssignment;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_operator_id")
    public    RateOperator getRateOperator(){
        return rateOperator;
    }
    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }

    public void setRateOperator(RateOperator rateOperator) {
        this.rateOperator = rateOperator;
    }
}
