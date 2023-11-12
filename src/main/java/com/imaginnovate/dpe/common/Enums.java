package com.imaginnovate.dpe.common;

public class Enums {
    public enum RuleStatus {
        INACTIVE(0), ACTIVE(1), DRAFT(2);
        private int value;
        RuleStatus(int value) {this.value = value;}
        public int getValue() {return value;}
    }
    public enum EquipmentType {
        FLAT_BED(0), REEFER(1), VAN(2);
        private int value;
        EquipmentType(int value) {
            this.value = value;
        }
        public int getValue() {return value;}

        public static EquipmentType getByValue(int n) {
            for (EquipmentType type : EquipmentType.values()) {
                if (type.getValue() == n) {
                    return type;
                }
            }
            return null;
        }
    }

    public enum StopType {
        PICKUP(0), PICKUPORDELIVERY(1), DELIVERY(2);
        private int value;
        StopType(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
    }

    public enum RateCalculator {
        Minimum(1), Maximum(2), Percentage(3), Average(4), FlatRate(5), AdjustmentPercentage(6), RatePerMile(7);
        private int value;
        RateCalculator(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

    }

    public enum RuleType {
        Accessorial(0),BaseRate(1), Calendar(2), BaseRateConstraint(3), GlobalBaseRate(4), Geography(5), SellPrice(6), FinalRate(7);
        private int value;
        RuleType(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
    }

    public enum CalendarAdjustmentRuleType {
        SameDay(0), Day(1), Date(2);
        private int value;
        CalendarAdjustmentRuleType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

    }

    public enum DayOfWeek {
        SUNDAY(1),MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
        private int value;
        private DayOfWeek(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public enum RateDuration {
        SevenDays(7), FifteenDays(15), ThirtyDays(30), NinetyDays(90), OneYear(365);
        private int value;
        RateDuration(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public enum RateType {
        AveragePay(0),TargetPay(1), MaxBuy(2);
        private int value;
        RateType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static RateType getByValue(int n) {
            for (RateType type : RateType.values()) {
                if (type.getValue() == n) {
                    return type;
                }
            }
            return null;
        }
    }

    public enum RateField {
        Minimum(0), Average(1), Maximum(2);
        private int value;
        RateField(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public enum RateProviderId {

        SONAR("Sonar"), DAT("DAT"), TRUCKSTOP("Truckstop");

        private String val;

        RateProviderId(String value) {
            this.val = value;
        }

        public String getProviderId() {
            return val;
        }
    }

}


