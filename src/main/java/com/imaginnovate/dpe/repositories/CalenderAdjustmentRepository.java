package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.CalenderAdjustmentRateConfiguration;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.jboss.logging.annotations.Param;


import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class CalenderAdjustmentRepository implements PanacheRepositoryBase<CalenderAdjustmentRateConfiguration, Long> {
    Optional<List<CalenderAdjustmentRateConfiguration>> findCalenderAdjudtmentById(long ruleassignmentid){
        Query query=getEntityManager().createNativeQuery("select * from calendar_adjustment_rate_configuration where rule_assignment_id =:ruleassignmentid")
                .setParameter("ruleassignmentid",ruleassignmentid);
        List list = query.getResultList();
        return Optional.ofNullable(list);
    }


    List<CalenderAdjustmentRateConfiguration> findByAssignmentAndOperatorAndRuleType(long ruleAssignmentId, long rateOperatorId, long applicableForRateTypeId){
        Query query=getEntityManager().createNativeQuery(" select * from calendar_adjustment_rate_configuration where rule_assignment_id = :ruleAssignmentId and rate_operator_id = :rateOperatorId  and calender_adjustment_rule_type = :applicableForRateTypeId")
                .setParameter("ruleAssignmentId",ruleAssignmentId)
                .setParameter("rateOperatorId",rateOperatorId)
                .setParameter("applicableForRateTypeId",applicableForRateTypeId);
       return query.getResultList();
    }




    CalenderAdjustmentRateConfiguration findCalenderAdjustmentByIdAndRuleType(List<Long> ids, int ruleType){
        Query query=getEntityManager().createNativeQuery("SELECT * FROM calendar_adjustment_rate_configuration ca WHERE ca.id IN :ids AND ca.calender_adjustment_rule_type = :ruleType")
                .setParameter("ids",ids)
                .setParameter("ruleType",ruleType);
        query.unwrap(NativeQuery.class).addEntity(CalenderAdjustmentRateConfiguration.class);
        return (CalenderAdjustmentRateConfiguration) query.getResultList().get(0);
    }
}
