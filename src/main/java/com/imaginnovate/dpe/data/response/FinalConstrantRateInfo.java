package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinalConstrantRateInfo {

    private RateTypeRateInfo finalMaxRate = new RateTypeRateInfo(0d, 0d);;

    private RateTypeRateInfo finalTargetRate = new RateTypeRateInfo(0d, 0d);;

}
