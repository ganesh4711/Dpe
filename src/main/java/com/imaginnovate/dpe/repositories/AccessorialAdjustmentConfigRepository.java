package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.AccessorialAdjustmentConfig;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AccessorialAdjustmentConfigRepository implements PanacheRepositoryBase<AccessorialAdjustmentConfig, Long> {
    //    @Query(value = "select * from accessorial_adjustment_configuration " +
//            "where rule_assignment_id = :ruleAssignmentId\n" +
//            "            and rate_operator_id = :rateOperatorId", nativeQuery = true )
    public List<AccessorialAdjustmentConfig> findByRuleAssignmentIdAndRateOperatorId(long ruleAssignmentId, long rateOperatorId) {
        return list("rule_assignment_id = ?1 and rate_operator_id = ?2", ruleAssignmentId, rateOperatorId);
    }

    //    @Query(value = """
//            SELECT * from accessorial_adjustment_configuration brc\s
//            where rule_assignment_id = :ruleAssignmentId
//            """, nativeQuery = true)
    public List<AccessorialAdjustmentConfig> findByRuleAssignmentId(long ruleAssignmentId) {
        return list("rule_assignment_id =?1", ruleAssignmentId);
    }

    //    @Query(value = "select id from  accessorial_adjustment_configuration WHERE rule_assignment_id =:ruleAssignmentId",nativeQuery = true)
    public List<Long> findAccessorialAdjustmentConfigIdsByRuleAssignmentId(Long ruleAssignmentId) {

        return find("rule_assignment_id =?1", ruleAssignmentId)
                .stream()
                .map(AccessorialAdjustmentConfig::getId)
                .collect(Collectors.toList());
    }

    AccessorialAdjustmentConfig getById(Long id){
        return find("id =?1",id).singleResult();
    }
}
