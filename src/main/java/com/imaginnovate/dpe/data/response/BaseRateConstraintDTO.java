package com.imaginnovate.dpe.data.response;

import com.imaginnovate.dpe.common.Enums.RuleStatus;
import com.imaginnovate.dpe.entities.BaseRateConstraintConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class BaseRateConstraintDTO {
    private Long id;

    private Long ruleAssignmentId;

    private double targetPay;

    private double maxPay;

    private RuleStatus status;

    private List<Integer> equipmentTypes;

    public BaseRateConstraintDTO(BaseRateConstraintConfig baseRateConstraintConfig) {
        this.id = baseRateConstraintConfig.getId();
        this.ruleAssignmentId = baseRateConstraintConfig.getRuleAssignment().getId();
        this.targetPay = baseRateConstraintConfig.getTargetPay();
        this.maxPay = baseRateConstraintConfig.getMaxBuy();
        this.status = baseRateConstraintConfig.getRuleAssignment().getRule().getStatus();
        this.equipmentTypes = baseRateConstraintConfig.getEquipments();
    }
}
