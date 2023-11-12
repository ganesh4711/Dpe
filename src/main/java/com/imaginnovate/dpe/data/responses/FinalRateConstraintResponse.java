package com.imaginnovate.dpe.data.responses;

import com.imaginnovate.dpe.entities.FinalRateConstraintConfig;
import com.imaginnovate.dpe.entities.RateEquipmentType;
import lombok.Data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.imaginnovate.dpe.common.Enums.RateType.MaxBuy;
import static com.imaginnovate.dpe.common.Enums.RateType.TargetPay;

@Data
public class FinalRateConstraintResponse {
    public FinalRateConstraintResponse(FinalRateConstraintConfig finalRateConstrain) {
        this.id= finalRateConstrain.getId();
        this.ruleAssignmentId = finalRateConstrain.getRuleAssignment().getId();
        this.targetPay = finalRateConstrain.getTargetPay();
        this.maxBuy = finalRateConstrain.getMaxBuy();
        this.minMileage = finalRateConstrain.getMinMileage();
        this.maxMileage = finalRateConstrain.getMaxMileage();
        this.equipmentTypes = finalRateConstrain.getRateEquipmentTypes().stream().collect(Collectors.toList());
    }
    private  long id;
    private long ruleAssignmentId;
    private double targetPay;
    private double maxBuy;
    private double maxMileage;
    private double minMileage;
    private List<Integer> equipmentTypes;
}
