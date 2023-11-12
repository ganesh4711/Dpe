package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rate {
    private double maxPay;
    private double targetPay;
}
