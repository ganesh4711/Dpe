package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrimaryConfigurationRateInfo {

    private RateTypeRateInfo primaryRateMaxRate = new RateTypeRateInfo(0d,0d);

    private RateTypeRateInfo primaryRateTargetRate = new RateTypeRateInfo(0d,0d);


}
