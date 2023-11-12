package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.BaseRateConstraintConfig;
import com.imaginnovate.dpe.entities.RuleAssignment;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class BaseRateConstrainRepository implements PanacheRepositoryBase<BaseRateConstraintConfig, Long> {

    public List<BaseRateConstraintConfig> findAllByRuleAssignment(Long ruleAssignment_id) {
        return list("ruleAssignment.id = ?1", ruleAssignment_id);
    }

}
