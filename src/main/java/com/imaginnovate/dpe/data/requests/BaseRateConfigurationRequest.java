package com.imaginnovate.dpe.data.requests;

import com.imaginnovate.dpe.common.Enums.RateType;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BaseRateConfigurationRequest {
   @Nullable
   public long id;
   public List<Integer> equipmentTypes;
   public RateType applicableForRateType;
   public long rateOperatorId;
   public List<RateSetting> rateSettings;
}
