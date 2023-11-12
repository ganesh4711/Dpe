package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.common.Enums.CalendarAdjustmentRuleType;
import com.imaginnovate.dpe.common.Enums.DayOfWeek;
import com.imaginnovate.dpe.common.Enums.StopType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "calendar_adjustment_rate_configuration")
@EntityListeners(BaseEntityListener.class)
public class CalenderAdjustmentRateConfiguration extends BaseEntity {
    private RuleAssignment ruleAssignment;
    private RateOperator rateOperator;
    private double adjustmentValue;
    private String description;
    private CalendarAdjustmentRuleType calenderAdjustmentRuleType;
    private Date applyFrom;
    private Date applyTo;
    private StopType calenderAdjustmentStopType;
    private DayOfWeek dayOfTheWeek;
    private List<RateEquipmentType> rateEquipmentTypes;

    @Transient
    public List<RateEquipmentType> getRateEquipmentTypes() {
        return rateEquipmentTypes;
    }

    public void setRateEquipmentTypes(List<RateEquipmentType> rateEquipmentTypes) {
        this.rateEquipmentTypes = rateEquipmentTypes;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_assignment_id")
    public RuleAssignment getRuleAssignment() {
        return ruleAssignment;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "rate_operator_id")
    public RateOperator getRateOperator() {
        return rateOperator;
    }
    @Column(name ="adjustment_value")
    public double getAdjustmentValue() {
        return adjustmentValue;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name ="calender_adjustment_rule_type" )
    @Enumerated(EnumType.ORDINAL)
    public CalendarAdjustmentRuleType getCalenderAdjustmentRuleType() {
        return calenderAdjustmentRuleType;
    }

    @Column(name = "apply_from")
    public Date getApplyFrom() {
        return applyFrom;
    }

    @Column(name = "apply_to")
    public Date getApplyTo() {
        return applyTo;
    }
    @Column(name = "calender_adjustment_stop_type")
    @Enumerated(EnumType.ORDINAL)
    public StopType getCalenderAdjustmentStopType() {
        return calenderAdjustmentStopType;
    }

    @Column(name = "day_of_the_week")
    @Enumerated(EnumType.ORDINAL)
    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setRuleAssignment(RuleAssignment ruleAssignment) {
        this.ruleAssignment = ruleAssignment;
    }

    public void setRateOperator(RateOperator rateOperator) {
        this.rateOperator = rateOperator;
    }

    public void setAdjustmentValue(double adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalenderAdjustmentRuleType(CalendarAdjustmentRuleType calenderAdjustmentRuleType) {
        this.calenderAdjustmentRuleType = calenderAdjustmentRuleType;
    }

    public void setApplyFrom(Date applyFrom) {
        this.applyFrom = applyFrom;
    }

    public void setApplyTo(Date applyTo) {
        this.applyTo = applyTo;
    }

    public void setCalenderAdjustmentStopType(StopType calenderAdjustmentStopType) {
        this.calenderAdjustmentStopType = calenderAdjustmentStopType;
    }

    public void setDayOfTheWeek(DayOfWeek dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
