package com.imaginnovate.dpe.data.domain;

import com.imaginnovate.dpe.entities.Rule;
import com.imaginnovate.dpe.entities.RuleAssignment;
import com.imaginnovate.dpe.entities.RuleSet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RuleSetValidationDTO {
    private RuleSet ruleSet;
    private Rule rule;
    private RuleAssignment ruleAssignment;
}
