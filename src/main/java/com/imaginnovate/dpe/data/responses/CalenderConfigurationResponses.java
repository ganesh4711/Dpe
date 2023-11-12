package com.imaginnovate.dpe.data.responses;

import com.imaginnovate.dpe.data.domain.RuleDTO;
import lombok.Data;

import java.util.List;

@Data
public class CalenderConfigurationResponses {

    private List<CalenderDTO> configurations;
    private long id;
    private RuleDTO rule;
    private long ruleSetId;
    private String createdAt;
    private String updatedAt;



}
