package com.imaginnovate.dpe.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Data
public class SonarRateResponse implements Serializable {

    /**
     *
     */
    static final long serialVersionUID = -2756755670865207248L;

    @JsonProperty("od_pair")
    private String odPair;
    @JsonProperty("rate_high")
    private Double rateHigh;
    @JsonProperty("rate")
    private Double rate;
    @JsonProperty("rate_low")
    private Double rateLow;
    @JsonProperty("data_timestamp")
    private String dataTimestamp;
    @JsonProperty("equipment_type")
    private String equipmentType;
    @JsonProperty("effective_origin_radius")
    private Double effectiveOriginRadius;
    @JsonProperty("effective_dest_radius")
    private Double effectiveDestRadius;
    @JsonProperty("effective_timeframe_in_days")
    private Double effectiveTimeFrameInDays;
    @JsonProperty("effective_load_count")
    private Double effectiveLoadCount;
    @JsonProperty("total_load_count")
    private Double totalLoadCount;
    @JsonProperty("effective_miles")
    private Double effectiveMiles;
    @JsonProperty("lane_confidence")
    private Double laneConfidence;

}
