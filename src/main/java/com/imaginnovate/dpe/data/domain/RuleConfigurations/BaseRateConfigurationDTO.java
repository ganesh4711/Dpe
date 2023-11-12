package com.imaginnovate.dpe.data.domain.RuleConfigurations;

import com.imaginnovate.dpe.common.Enums;
import com.imaginnovate.dpe.data.domain.RuleAssignmentDTO;
import com.imaginnovate.dpe.data.requests.RateSetting;
import com.imaginnovate.dpe.entities.BaseRateConfiguration;

import java.util.List;
import java.util.stream.Collectors;

public class BaseRateConfigurationDTO {

    public long id;
    public long ruleAssignmentId;
    public List<RateSetting> rateSettings;
    public List<Integer> equipments;
    public Enums.RateType applicableForRateType;
    public long rateOperatorId;

    public BaseRateConfigurationDTO(BaseRateConfiguration baseRateConfiguration) {
        this.id = baseRateConfiguration.getId();
        this.ruleAssignmentId = baseRateConfiguration.getRuleAssignment().getId();
        this.equipments = baseRateConfiguration.getRateEquipmentTypes().stream().map(e -> e.getEquipmentType().getValue()).collect(Collectors.toList());
        this.rateSettings = baseRateConfiguration.getRateSettings().stream().map(rateSetting -> new RateSetting(rateSetting)).collect(Collectors.toList());
        this.applicableForRateType = baseRateConfiguration.getApplicableForRateType();
        this.rateOperatorId = baseRateConfiguration.getRateOperator().getId();
    }
}
