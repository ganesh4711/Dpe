package com.imaginnovate.dpe.data.requests;

import lombok.Data;

import java.util.List;

@Data
public class AccessorialAdjustmentConfigRequest {
    private long rateOperatorId;
    private double adjustmentValue;
    private List<Integer> rateEquipmentTypes;
    private List<Long> accessorials;
}
