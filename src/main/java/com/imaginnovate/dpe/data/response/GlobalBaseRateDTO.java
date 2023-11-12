package com.imaginnovate.dpe.data.response;

import com.imaginnovate.dpe.common.Enums.RuleStatus;
import com.imaginnovate.dpe.entities.PrimaryBaseRateConfiguration;
import com.imaginnovate.dpe.entities.RateEquipmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalBaseRateDTO {
    private Long id;

    private Long ruleAssignmentId;

    private double adjustmentValue;


    private List<Integer> equipmentTypes;


    public GlobalBaseRateDTO(PrimaryBaseRateConfiguration primaryBaseRateConfiguration) {
        this.id = primaryBaseRateConfiguration.getId();
        this.ruleAssignmentId = primaryBaseRateConfiguration.getRuleAssignment().getId();
        this.adjustmentValue = primaryBaseRateConfiguration.getAdjustmentValue();
        this.equipmentTypes = new ArrayList<>(primaryBaseRateConfiguration.getRateEquipmentTypes());
    }
}
