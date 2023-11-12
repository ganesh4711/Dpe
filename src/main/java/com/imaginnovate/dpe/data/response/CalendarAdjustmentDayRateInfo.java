package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalendarAdjustmentDayRateInfo {
    private RateTypeRateInfo calendarAdjustmentDayMaxRate= new RateTypeRateInfo(0d,0d);;
    private RateTypeRateInfo calendarAdjustmentDayTargetRate= new RateTypeRateInfo(0d,0d);;
}
