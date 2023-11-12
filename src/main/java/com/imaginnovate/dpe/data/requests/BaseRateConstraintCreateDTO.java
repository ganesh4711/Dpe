package com.imaginnovate.dpe.data.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRateConstraintCreateDTO {

    private double targetPay;

    private double maxBuy;

    private int[] equipmentTypes;
}
