package com.imaginnovate.dpe.data.domain;

import com.imaginnovate.dpe.entities.Rule;
import com.imaginnovate.dpe.entities.RuleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class RuleAssignmentDTO {

    private long id;
    private long ruleSetId;
    private RuleDTO rule;
    private Date createdAt;
    private Date updatedAt;

    public RuleAssignmentDTO(RuleAssignment ruleAssignment, Rule rule) {
        this.id = ruleAssignment.getId();
        this.ruleSetId = ruleAssignment.getRuleSet().getId();
        this.rule = new RuleDTO(rule);
        this.createdAt = ruleAssignment.getCreatedAt();
        this.updatedAt = ruleAssignment.getUpdatedAt();
    }
}
