package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SameDayPickUpRateInfo {

    private RateTypeRateInfo sameDayPickUpAdjustmentMaxRate= new RateTypeRateInfo(0d,0d);;

    private RateTypeRateInfo sameDayPickUpAdjustmentTargetRate= new RateTypeRateInfo(0d,0d);;



}
