package com.imaginnovate.dpe.entities;
import com.imaginnovate.dpe.common.Enums.RuleStatus;
import com.imaginnovate.dpe.common.Enums.RuleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rules")
@EntityListeners(BaseEntityListener.class)
public class Rule extends BaseEntity {

    private  String name;
    private  String code;
    private  String description;
    private  RuleType ruleType;
    private RuleStatus status;

    private boolean isRequired;
   @Column(name = "is_required")
    public boolean getIsRequired() {
        return isRequired;
    }
    public void setIsRequired(boolean required) {
        isRequired = required;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "rule_type")
    @Enumerated(EnumType.ORDINAL)
    public RuleType getRuleType() {
        return ruleType;
    }
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    public RuleStatus getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public void setStatus(RuleStatus status) {
        this.status = status;
    }
}
