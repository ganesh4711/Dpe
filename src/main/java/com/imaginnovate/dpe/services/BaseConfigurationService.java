package com.imaginnovate.dpe.services;

import com.imaginnovate.dpe.data.domain.RuleSetValidationDTO;
import com.imaginnovate.dpe.entities.Rule;
import com.imaginnovate.dpe.entities.RuleAssignment;
import com.imaginnovate.dpe.entities.RuleSet;
import com.imaginnovate.dpe.exceptions.NotFoundException;
import com.imaginnovate.dpe.repositories.RuleAssignmentRepository;
import com.imaginnovate.dpe.repositories.RuleRepository;
import com.imaginnovate.dpe.repositories.RuleSetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


import java.util.List;

@ApplicationScoped
public class BaseConfigurationService {


    @Inject
    private RuleSetRepository ruleSetRepository;

    @Inject
    private RuleRepository ruleRepository;

    @Inject
    private RuleAssignmentRepository ruleAssignmentRepository;

    protected RuleSetValidationDTO validateAndGetRuleAssignmentDataForEditing(long ruleSetId, String ruleCode, boolean throwExceptionIfAssignmentNotPresent) throws NotFoundException {
        RuleSet ruleSet = ruleSetRepository.findById(ruleSetId);
        if (ruleSet == null) {
            throw new NotFoundException("RuleSet with Id: " + ruleSetId + " not found");
        } else {
            // TODO: add validation to see if rule set can be editable
        }
        Rule rule = ruleRepository.findByCode(ruleCode);

        if (rule == null) {
            throw new NotFoundException("Rule with code: " + ruleCode + " not found");
        }

        List<RuleAssignment> ruleAssignments = ruleAssignmentRepository.findAllByRuleSetIdAndRuleCode(ruleSetId, ruleCode);

        if (throwExceptionIfAssignmentNotPresent && ruleAssignments.isEmpty()) {
            throw new NotFoundException("Rule assignment not found for ruleset: " + ruleSetId + " and rule: " + ruleCode);
        }
        return new RuleSetValidationDTO(ruleSet, rule, !ruleAssignments.isEmpty() ? ruleAssignments.get(0) : null);

    }
}
