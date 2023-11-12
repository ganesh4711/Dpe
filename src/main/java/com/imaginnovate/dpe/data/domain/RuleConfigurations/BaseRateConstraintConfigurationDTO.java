package com.imaginnovate.dpe.data.domain.RuleConfigurations;

import com.imaginnovate.dpe.entities.BaseRateConstraintConfig;
import lombok.Data;

import java.util.List;

@Data
public class BaseRateConstraintConfigurationDTO {

    public BaseRateConstraintConfigurationDTO(BaseRateConstraintConfig baseRateConstraintConfig) {
        this.id = baseRateConstraintConfig.getId();
        this.ruleAssignmentId = baseRateConstraintConfig.getRuleAssignment().getId();
        this.targetPay = baseRateConstraintConfig.getTargetPay();
        this.maxPay = baseRateConstraintConfig.getMaxBuy();
        // fetch equipments related stuff in and set it here
    }

    private long id;
    private long ruleAssignmentId;
    private double targetPay;
    private double maxPay;

    // TODO: Set equipment types
    private List<Integer> equipmentTypes;
}
