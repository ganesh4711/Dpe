package com.imaginnovate.dpe.entities.misc;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class GeoCityId implements Serializable {
    private String name;

    private String stateCode;

    private String countryCode;
}
