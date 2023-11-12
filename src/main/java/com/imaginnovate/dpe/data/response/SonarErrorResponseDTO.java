package com.imaginnovate.dpe.data.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SonarErrorResponseDTO implements Serializable {

    /**
     *
     */
    static final long serialVersionUID = -7736113454176793231L;

    @JsonProperty("StatusCode")
    private Integer statusCode;

    @JsonProperty("Message")
    private String message;

    public SonarErrorResponseDTO() {
    }
}
