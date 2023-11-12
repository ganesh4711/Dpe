package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.PrimaryBaseRateConfiguration;
import com.imaginnovate.dpe.entities.RuleAssignment;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PrimaryBaseRateConfigurationRepository implements PanacheRepositoryBase<PrimaryBaseRateConfiguration,Long> {

    public List<PrimaryBaseRateConfiguration> findAllByRuleAssignment(RuleAssignment ruleAssignment){
        return list("ruleAssignment = ?1",ruleAssignment);
    }
}
