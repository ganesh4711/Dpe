package com.imaginnovate.dpe.data.responses;

import com.imaginnovate.dpe.entities.AccessorialAdjustmentConfig;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AccessorialAdjustmentConfigResponse {
    private long id;
    private List<Long> accessorials;
    private long ruleAssignmentId;
    private double adjustmentValue;
    private long rateOperatorId;
    private List<Integer> rateEquipmentTypes;

    public AccessorialAdjustmentConfigResponse(AccessorialAdjustmentConfig accessorialAdjustmentConfig) {
        this.id = accessorialAdjustmentConfig.getId();
        this.accessorials = accessorialAdjustmentConfig.getAccessorial();
        this.ruleAssignmentId = accessorialAdjustmentConfig.getRuleAssignment().getId();
        this.adjustmentValue = accessorialAdjustmentConfig.getAdjustmentValue();
        this.rateOperatorId = accessorialAdjustmentConfig.getRateOperator().getId();
        this.rateEquipmentTypes = new ArrayList<>(accessorialAdjustmentConfig.getEquipments());
    }
}
