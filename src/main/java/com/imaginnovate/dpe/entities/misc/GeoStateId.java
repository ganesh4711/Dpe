package com.imaginnovate.dpe.entities.misc;

import lombok.Data;

import java.io.Serializable;

@Data
public class GeoStateId implements Serializable {
    private String code;
    private String countryCode;
}
