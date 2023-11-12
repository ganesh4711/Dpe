package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.common.Enums.RateCalculator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rate_operator")
@EntityListeners(BaseEntityListener.class)
public class RateOperator extends BaseEntity{

    private  String operatorName;
    private  String code;
    private  String description;
    private RateCalculator applicableFor;

    @Column(name = "name")
    public String getOperatorName() {
        return operatorName;
    }
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    @Column(name ="description" )
    public String getDescription() {
        return description;
    }
    @Column(name ="applicable_for" )
    @Enumerated(EnumType.ORDINAL)
    public RateCalculator getApplicableFor() {
        return applicableFor;
    }

    public void setApplicableFor(RateCalculator applicableFor) {
        this.applicableFor = applicableFor;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

