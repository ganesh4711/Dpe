package com.imaginnovate.dpe.data.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CalenderRuleOptionsResponse {


    private List<EquipmentType> equipmentTypes;
    private List<RateOperator> rateOperators;
    private List<DayOfWeek> dayOfWeeks;
    private List<CalendarAdjustmentRuleType> calendarAdjustmentRuleTypes;
    private List<CalendarAdjustmentStopType> calendarAdjustmentStopTypes;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DayOfWeek {
        private int id;
        private String code;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CalendarAdjustmentRuleType {
        private int id;
        private String name;
        private String code;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CalendarAdjustmentStopType {
        private int id;
        private String code;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EquipmentType {
        private int id;
        private String code;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateOperator {
        private int id;
        private String name;
        private boolean usesWeightage;
    }



}
