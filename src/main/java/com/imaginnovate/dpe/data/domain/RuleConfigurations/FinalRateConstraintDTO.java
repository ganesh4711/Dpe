package com.imaginnovate.dpe.data.domain.RuleConfigurations;

import com.imaginnovate.dpe.entities.FinalRateConstraintConfig;
import lombok.Data;

import java.util.List;

@Data
public class FinalRateConstraintDTO {
    public FinalRateConstraintDTO(FinalRateConstraintConfig finalRateConstraintConfig) {
        this.id = finalRateConstraintConfig.getId();
        this.ruleAssignmentId = finalRateConstraintConfig.getRuleAssignment().getId();
        this.targetPay = finalRateConstraintConfig.getTargetPay();
        this.maxPay = finalRateConstraintConfig.getMaxBuy();
        this.minMileage = finalRateConstraintConfig.getMinMileage();
        this.maxMileage = finalRateConstraintConfig.getMaxMileage();
        // fetch equipments related stuff in and set it here
    }

    private long id;
    private long ruleAssignmentId;
    private double targetPay;
    private double maxPay;
    private double minMileage;
    private double maxMileage;
    private  long createdId;
    private List<Integer> equipmentTypes;
}
