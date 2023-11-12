package com.imaginnovate.dpe.data.requests;

import com.imaginnovate.dpe.common.Enums;
import lombok.Data;

import java.util.List;
@Data
public class BaseRateRule {

    public long id ;
    public String ruleSetName;
    public List<Integer> equipmentTypes ;
    public Enums.RateType applicableForRateType ;
    public long rateOperatorId ;
    public List<RateSetting> rateSettings ;


}
