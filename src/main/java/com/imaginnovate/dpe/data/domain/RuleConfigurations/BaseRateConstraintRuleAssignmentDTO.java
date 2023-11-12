package com.imaginnovate.dpe.data.domain.RuleConfigurations;

import com.imaginnovate.dpe.data.domain.RuleAssignmentDTO;
import com.imaginnovate.dpe.data.domain.RuleDTO;

import java.util.Date;
import java.util.List;

public class BaseRateConstraintRuleAssignmentDTO extends RuleAssignmentDTO {

    List<BaseRateConstraintConfigurationDTO> configurations;


    public BaseRateConstraintRuleAssignmentDTO(long id, long ruleSetId, RuleDTO rule, Date createdAt, Date updatedAt, List<BaseRateConstraintConfigurationDTO> configurations) {
        super(id, ruleSetId, rule, createdAt, updatedAt);
        this.configurations = configurations;
    }


}
