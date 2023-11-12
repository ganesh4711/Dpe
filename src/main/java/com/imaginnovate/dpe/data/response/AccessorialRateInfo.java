package com.imaginnovate.dpe.data.response;

import lombok.Data;

@Data
public class AccessorialRateInfo {

    private RateTypeRateInfo accessorialMaxRate = new RateTypeRateInfo(0d,0d);

    private RateTypeRateInfo accessorialTargetRate = new RateTypeRateInfo(0d,0d);

    public AccessorialRateInfo(RateTypeRateInfo accessorialMaxRate, RateTypeRateInfo accessorialTargetRate) {
        super();
        this.accessorialMaxRate = accessorialMaxRate;
        this.accessorialTargetRate = accessorialTargetRate;
    }

}
