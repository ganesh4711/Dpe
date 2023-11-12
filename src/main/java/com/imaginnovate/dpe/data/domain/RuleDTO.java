package com.imaginnovate.dpe.data.domain;

import com.imaginnovate.dpe.entities.Rule;
import lombok.Data;

@Data
public class RuleDTO {

    public RuleDTO(Rule rule) {
        this.id = rule.getId();
        this.code = rule.getCode();
        this.name = rule.getName();
        this.description = rule.getDescription();
    }
    private long id;
    private String code;
    private String name;
    private String description;
    // handle ruleType,
}
