package com.imaginnovate.dpe.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdjustmentRates {
    private double maxRate;
    private double targetRate;

    public void updateAdjustment(double adjustmentValue) {
        maxRate += adjustmentValue;
        targetRate += adjustmentValue;
    }

}
