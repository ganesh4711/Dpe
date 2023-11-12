package com.imaginnovate.dpe.data.requests;

import lombok.Data;

import java.util.List;

@Data
public class FinalRateConfigRequest {
    public List<Integer> equipmentTypes;
    private  double minMileage;
    private  double maxMileage;
    private double targetPay;
    private  double maxBuy;

}
