package com.imaginnovate.dpe.data.responses;

import com.imaginnovate.dpe.entities.ShipperRateConfiguration;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ShipperRateConfigurationResponse {

    public ShipperRateConfigurationResponse(ShipperRateConfiguration shipperRateConfiguration) {
        this.id = shipperRateConfiguration.getId();
        this.ruleAssignmentId = shipperRateConfiguration.getRuleAssignment().getId();
        this.operatorId = shipperRateConfiguration.getRateOperator().getId();
        this.adjustmentValue = shipperRateConfiguration.getAdjustmentValue();
        this.rateEquipmentTypes = shipperRateConfiguration.getEquipments().stream().collect(Collectors.toList());

    }

    private long id;
    private long ruleAssignmentId;
    private double adjustmentValue;
    private long operatorId;
    private List<Integer> rateEquipmentTypes;

}
