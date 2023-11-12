package com.imaginnovate.dpe.data.requests;

import lombok.Data;

import java.util.List;

@Data
public class ShipperRateRequest {
    private long rateOperatorId;
    private double adjustmentValue;
    private List<Integer> equipmentTypes;

}