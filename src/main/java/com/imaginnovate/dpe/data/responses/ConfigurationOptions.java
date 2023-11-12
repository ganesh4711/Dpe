package com.imaginnovate.dpe.data.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
public class ConfigurationOptions {

    private List<RateType> rateTypes;
    private List<EquipmentType> equipmentTypes;
    private List<RateField> rateFields;
    private List<RateOperator> rateOperators;
    private List<RateSource> rateSources;

    private Long id;
    private String code;
    private String name;
    private String description;
    private int outputType;
    private int status;
    private Date createdAt;
    private Date updatedAt;



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateType {
        private int id;
        private String code;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateSource {
        private Long id;
        private String name;
        private String code;
        private List<String> rateFields;
        private List<String> rateWindows;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateField {
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
