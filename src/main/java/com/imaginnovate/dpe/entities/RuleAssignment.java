package com.imaginnovate.dpe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="rule_assignment" )
@EntityListeners(BaseEntityListener.class)
public class RuleAssignment extends BaseEntity {


    private Rule rule;

    private  RuleSet ruleSet;

    public RuleAssignment(int ruleId, int ruleSet) {
        this.rule = getRule();
        this.ruleSet = getRuleSet();
    }

    public RuleAssignment(Long id, RuleSet ruleSet) {
        super();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_id")
    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_set_id")
    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }
}
