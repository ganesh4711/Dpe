package com.imaginnovate.dpe.data.response;

import lombok.Data;

@Data
public class DATEscalationDTO {
    private String timeframe;

    private DATEscalationLocationDTO origin;

    private DATEscalationLocationDTO destination;
    public DATEscalationDTO() {

    }
}

