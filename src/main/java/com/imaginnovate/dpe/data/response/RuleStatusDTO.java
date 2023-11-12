package com.imaginnovate.dpe.data.response;

import com.imaginnovate.dpe.data.domain.RuleConfigurations.BaseRateConfigurationDTO;
import com.imaginnovate.dpe.data.responses.AccessorialAdjustmentConfigResponse;
import com.imaginnovate.dpe.data.responses.CalenderConfigurationResponses;
import com.imaginnovate.dpe.data.responses.FinalRateConstraintResponse;
import com.imaginnovate.dpe.data.responses.ShipperRateConfigurationResponse;
import lombok.Data;

import java.util.List;

@Data
public class RuleStatusDTO {
    private List<BaseRateConfigurationDTO> baseRateConfigs;
    private CalenderConfigurationResponses calendarRateConfigs;
    private List<BaseRateConstraintDTO> baseRateConstraintConfigs;
    private List<GlobalBaseRateDTO> primaryBaseRateConfigs;
    private List<ShipperRateConfigurationResponse> shipperRateConfigs;
    private List<FinalRateConstraintResponse> finalRateConfigs;
    private List<AccessorialAdjustmentConfigResponse> accessorialRateConfig;
}
