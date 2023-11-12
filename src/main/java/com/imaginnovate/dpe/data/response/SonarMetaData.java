package com.imaginnovate.dpe.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApplicationScoped
public class SonarMetaData  {

	
	@JsonProperty("effective_origin_radius")
	private Double effectiveOriginRadius;

	@JsonProperty("effective_dest_radius")
	private Double effectiveDestRadius;

	@JsonProperty("effective_timeframe_in_days")
	private Double effectiveTimeframeInDays;

	@JsonProperty("effective_load_count")
	private Double effectiveLoadCount;

	@JsonProperty("effective_miles")
	private Double effectiveMiles;

	@JsonProperty("lane_confidence")
	private Double laneConfidence;

	@JsonProperty("total_load_count")
	private Double totalLoadCount;

	public SonarMetaData(Double effectiveOriginRadius, Double effectiveDestRadius, Double effectiveTimeframeInDays, Double effectiveLoadCount, Double effectiveMiles, Double laneConfidence, Double totalLoadCount) {
		this.effectiveOriginRadius = effectiveOriginRadius;
		this.effectiveDestRadius = effectiveDestRadius;
		this.effectiveTimeframeInDays = effectiveTimeframeInDays;
		this.effectiveLoadCount = effectiveLoadCount;
		this.effectiveMiles = effectiveMiles;
		this.laneConfidence = laneConfidence;
		this.totalLoadCount = totalLoadCount;
	}
}
