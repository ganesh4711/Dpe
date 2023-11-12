package com.imaginnovate.dpe.entities.misc;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class GeoCityGeoZipId implements Serializable {
    private String cityName;

    private String stateCode;

    private String zipCode;

    private String countryCode;
}
