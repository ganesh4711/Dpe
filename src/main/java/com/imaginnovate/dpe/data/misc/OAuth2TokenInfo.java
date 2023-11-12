package com.imaginnovate.dpe.data.misc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAuth2TokenInfo {

    @JsonProperty("access_token")
    private String access_token;

    @JsonProperty("expires_in")
    private Integer expires_in;

    @JsonProperty("refresh_expires_in")
    private Integer refresh_expires_in;

    @JsonProperty("refresh_token")
    private String refresh_token;

    @JsonProperty("token_type")
    private String token_type;

    @JsonProperty("session_state")
    private String session_state;

    @JsonProperty("scope")
    private String scope;

}
