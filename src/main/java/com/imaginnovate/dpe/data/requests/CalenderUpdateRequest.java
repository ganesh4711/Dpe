package com.imaginnovate.dpe.data.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalenderUpdateRequest {

    private long id;
    private long ruleAssignmentId;
    private long rateOperatorId;
    private double adjustmentValue;
    private String description;
    private Date applyFrom;
    private Date applyTo;
    private long dayOfWeek;
    private long calendarAdjustmentRuleType;
    private long calendarAdjustmentStopType;
    private int status;
    private List<Integer> equipmentTypes;
}
