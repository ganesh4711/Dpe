package com.imaginnovate.dpe.data.domain.RuleConfigurations;

import com.imaginnovate.dpe.data.domain.RuleAssignmentDTO;
import com.imaginnovate.dpe.data.domain.RuleDTO;
import com.imaginnovate.dpe.entities.BaseRateConfiguration;
import com.imaginnovate.dpe.entities.RuleAssignment;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BaseRateRuleAssignmentDTO extends RuleAssignmentDTO {

    List<BaseRateConfigurationDTO> configurations;

    public BaseRateRuleAssignmentDTO(long id, long ruleSetId, RuleDTO rule, Date createdAt, Date updatedAt, List<BaseRateConfigurationDTO> configurations) {
        super(id, ruleSetId, rule, createdAt, updatedAt);
        this.configurations = configurations;
    }

    public BaseRateRuleAssignmentDTO(RuleAssignment ruleAssignment, List<BaseRateConfiguration> baseRateConfigurations) {
        super(ruleAssignment.getId(), ruleAssignment.getRuleSet().getId(), new RuleDTO(ruleAssignment.getRule()), ruleAssignment.getCreatedAt(), ruleAssignment.getUpdatedAt());
        this.configurations = baseRateConfigurations.stream().map(x -> new BaseRateConfigurationDTO(x)).collect(Collectors.toList());
    }

}
