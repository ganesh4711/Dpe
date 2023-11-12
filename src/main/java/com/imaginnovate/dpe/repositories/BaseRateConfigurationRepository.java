package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.BaseRateConfiguration;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import org.jboss.logging.annotations.Param;

import java.util.List;

@ApplicationScoped
public class BaseRateConfigurationRepository implements PanacheRepositoryBase<BaseRateConfiguration, Long> {

//    @Query(value = """
//            SELECT * from base_rate_configuration brc\s
//            where rule_assignment_id = :ruleAssignmentId\s
//            and applicable_for_rate_type = :app_rate_type\s
//            and rate_operator_id = :rateOperatorId
//            """, nativeQuery = true)
public List<BaseRateConfiguration> findByRuleAndRateOperatorAndRateType(long ruleAssignmentId, long rateOperatorId, long appRateType){
        return list(
                "ruleAssignmentId = :ruleAssignmentId " +
                        "and appRateType = :appRateType " +
                        "and rateOperatorId = :rateOperatorId",
                Parameters.with("ruleAssignmentId", ruleAssignmentId)
                        .and("appRateType", appRateType)
                        .and("rateOperatorId", rateOperatorId)
        );
    }


    public List<BaseRateConfiguration> findAllByRuleAssignmentId(long ruleAssignmentId){
        return list("ruleAssignmentId = ?1",ruleAssignmentId);
    }

    List<BaseRateConfiguration> findAllByRuleAssignmentIdAndEquipmentId(long ruleAssignmentId,int equipmentType){
        Query query=getEntityManager().createQuery( "SELECT brc.* from base_rate_configuration brc" +
                " left join rate_equipment_type ret on brc.id = ret.rate_config_id " +
                "where brc.rule_assignment_id = :ruleAssignmentId " +
                "and ret.equipment_type = :equipmentType");
        query.setParameter("ruleAssignmentId",ruleAssignmentId);
        query.setParameter("equipmentType",equipmentType);

        return query.getResultList();
    }

}