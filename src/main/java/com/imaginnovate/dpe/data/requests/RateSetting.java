package com.imaginnovate.dpe.data.requests;

import com.imaginnovate.dpe.common.Enums;
import com.imaginnovate.dpe.entities.BaseRateSetting;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RateSetting {
    @Nullable
    public long id ;
    public long rateSourceId ;
    public Enums.RateField rateField ;
    public double weightage ;
    public int duration ;

    public RateSetting(BaseRateSetting baseRateSetting) {
        this.id = baseRateSetting.getId();
        this.rateSourceId = baseRateSetting.getRateSource().getId();
        this.rateField = baseRateSetting.getRateField();
        this.duration = baseRateSetting.getRateDuration();
        this.weightage = baseRateSetting.getWeightage();
    }
}
