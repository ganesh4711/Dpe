package com.imaginnovate.dpe.data.responses;

import com.imaginnovate.dpe.entities.CalenderAdjustmentRateConfiguration;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CalenderDTO {

    private long id;
    private long ruleAssignmentId;
    private long rateOperatorId;
    private double adjustmentValue;
    //private String displayAdjustmentValue;
    private String description;
    private Date applyFrom;
    private Date applyTo;
    private long dayOfWeek;
    private long calendarAdjustmentRuleType;
    private long calendarAdjustmentStopType;
    private int createdUserId;
    private String createdAt;
    private String updatedAt;
    private int status;
    private List<Integer> equipmentTypes;

    public CalenderDTO(){

    }

    public CalenderDTO(CalenderAdjustmentRateConfiguration calenderAdjustmentRateConfiguration){
        this.id = calenderAdjustmentRateConfiguration.getId();
        this.ruleAssignmentId = calenderAdjustmentRateConfiguration.getRuleAssignment().getId();
        this.rateOperatorId = calenderAdjustmentRateConfiguration.getRateOperator().getId();
        this.adjustmentValue = calenderAdjustmentRateConfiguration.getAdjustmentValue();
        this.description = calenderAdjustmentRateConfiguration.getDescription();
        this.applyFrom = calenderAdjustmentRateConfiguration.getApplyFrom();
        this.applyTo =  calenderAdjustmentRateConfiguration.getApplyTo();
        this.dayOfWeek = calenderAdjustmentRateConfiguration.getDayOfTheWeek() != null ?calenderAdjustmentRateConfiguration.getDayOfTheWeek().getValue():-1;
        this.calendarAdjustmentRuleType = calenderAdjustmentRateConfiguration.getCalenderAdjustmentRuleType().getValue();
        this.calendarAdjustmentStopType = calenderAdjustmentRateConfiguration.getCalenderAdjustmentStopType().getValue();
        this.equipmentTypes = calenderAdjustmentRateConfiguration.getRateEquipmentTypes().stream().map(e -> e.getEquipmentType().getValue()).collect(Collectors.toList());
   }



}