package com.imaginnovate.dpe.data.requests;

import com.imaginnovate.dpe.common.Enums;
import com.imaginnovate.dpe.entities.RateOperator;
import com.imaginnovate.dpe.entities.RuleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationRequest {

    private  Long ruleAssignmentId;
    private Long rateOperatorId;
    private String adjustmentValue;
    private String description;
    private String ruleType;
    private Timestamp applyFrom;
    private Timestamp applyTo;
    private String stopType;
    private String dayOfTheWeek;
//


//  public long Id { get; set; }
//        public string Description { get; set; }
//
//        public long RateOperatorId { get; set; }
//
//        public decimal AdjustmentValue { get; set; }
//
//        public CalendarAdjustmentRuleType RuleType { get; set; }
//
//        public CalendarAdjustmentStopType StopType { get; set; }
//
//        public DateTime? ApplyFrom { get; set; }
//
//        public DateTime? ApplyTo { get; set; }
//
//        public int? DayOfWeek { get; set; }
//
//        public int[] EquipmentTypes { get; set; }
}
