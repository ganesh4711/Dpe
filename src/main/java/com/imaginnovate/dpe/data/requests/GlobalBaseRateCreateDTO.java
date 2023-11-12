package com.imaginnovate.dpe.data.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalBaseRateCreateDTO {

    private Long id;

    private List<Integer> equipmentTypes;

    private double adjustmentValue;

}
