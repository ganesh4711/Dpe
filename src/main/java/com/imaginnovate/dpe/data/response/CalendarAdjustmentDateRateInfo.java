package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalendarAdjustmentDateRateInfo {

    private RateTypeRateInfo calendarAdjustmentDateMaxRate= new RateTypeRateInfo(0d,0d);;

    private RateTypeRateInfo calendarAdjustmentDateTargetRate= new RateTypeRateInfo(0d,0d);;

}
