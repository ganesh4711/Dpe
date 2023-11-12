package com.imaginnovate.dpe.data.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalenderRateRequest {


    private long ruleId;
    private long rateOperatorId;
    private double adjustmentValue;
    private String description;
    private Date applyFrom;
    private Date applyTo;
    private long calendarAdjustmentRuleType;
    private long calendarAdjustmentStopType;
    private long dayOfWeek;
    private List<Integer> equipmentTypes;
}
