package com.imaginnovate.dpe.data.domain;

import com.imaginnovate.dpe.entities.ApplicationUser;
import com.imaginnovate.dpe.entities.RuleSet;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RuleSetDTO {

    public RuleSetDTO(RuleSet ruleSet) {
        this.id = ruleSet.getId();
        this.name = ruleSet.getName();
        this.description = ruleSet.getDescription();
        this.createdAt = ruleSet.getCreatedAt();
        this.updatedAt = ruleSet.getUpdatedAt();
        this.createdUser = ruleSet.getCreatedUser();
        this.updatedUser = ruleSet.getUpdatedUser();
        this.ruleAssignmentDTOs=ruleSet.getRuleAssignmentDTOList();
    }
    private long id;

    private String name;

    private String description;

    private ApplicationUser createdUser;

    private ApplicationUser updatedUser;

    private Date createdAt;

    private Date updatedAt;

    private List<RuleAssignmentDTO> ruleAssignmentDTOs;
}
