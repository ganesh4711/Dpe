package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.ShipperRateConfiguration;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;


import java.util.List;

@ApplicationScoped
public class ShipperRateConfigurationRepository implements PanacheRepositoryBase<ShipperRateConfiguration,Long> {



    public List<ShipperRateConfiguration> findByRuleAssignmentIdAndRateOperator(long ruleAssignmentId, long rateOperatorId){
        Query query=getEntityManager().createNativeQuery("select * from shipper_rate_configuration where rule_assignment_id = :ruleAssignmentId and rate_operator_id=:rateOperatorId",ShipperRateConfiguration.class);
        query.setParameter("ruleAssignmentId",ruleAssignmentId)
                .setParameter("rateOperatorId",rateOperatorId);
        return query.getResultList();
    }

    public List<ShipperRateConfiguration> findAllByRuleAssignmentId(long ruleAssignmentId){
        Query query=getEntityManager().createNativeQuery("select * from shipper_rate_configuration where rule_assignment_id = :ruleAssignmentId",ShipperRateConfiguration.class);
        query.setParameter("ruleAssignmentId",ruleAssignmentId);
        return query.getResultList();
    }
}
