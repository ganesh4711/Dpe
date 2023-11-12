package com.imaginnovate.dpe.data.requests;

import lombok.Data;

import java.util.List;

@Data
public class BaseRequest {
    private Long id;
    private double targetPay;
    private double maxPay;
    private List<Integer> equipmentTypes;

}
